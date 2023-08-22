package com.backend.clinicaodontologica.service.impl;



import com.backend.clinicaodontologica.dao.IDao;
import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.entity.Paciente;
import com.backend.clinicaodontologica.service.IPacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PacienteService implements IPacienteService{
    private final IDao<Paciente> pacienteIDao;
    private final ModelMapper modelMapper;

    public PacienteService(IDao<Paciente> pacienteIDao, ModelMapper modelMapper) {
        this.pacienteIDao = pacienteIDao;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente){
        //convertir Dto de entrada a entidad para poder enviarlo a la capa de persistencia
        Paciente pacienteAPersistir = mapToEntity(paciente);
        Paciente pacienteRegistrado = pacienteIDao.registrar(pacienteAPersistir);



        return pacienteIDao.registrar(paciente);
    }


    public Paciente buscarPacientePorId(int id){
        return pacienteIDao.buscarPorId(id);
    }

    public List<Paciente> listarPacientes(){
        return pacienteIDao.listarTodos();
    }


    public void eliminarPaciente(int id){
        pacienteIDao.eliminar(id);
    }

    @Override
    public Paciente modificarPaciente(Paciente pacienteModificado) {
        return pacienteIDao.modificar(pacienteModificado);
    }


    private void configureMapping(){
        modelMapper.typeMap(PacienteEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilio, Paciente::setDomicilio));

    }

    public Paciente mapToEntity(PacienteEntradaDto pacienteEntradaDto){
        return modelMapper.map(pacienteEntradaDto, Paciente.class);
    }


}
