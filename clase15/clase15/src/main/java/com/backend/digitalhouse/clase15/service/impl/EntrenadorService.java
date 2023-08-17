package com.backend.digitalhouse.clase15.service.impl;


import com.backend.digitalhouse.clase15.entity.Entrenador;
import com.backend.digitalhouse.clase15.service.IEntrenadorService;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorService implements IEntrenadorService {

    //private static final Logger LOGGER = LoggerFactory.getLogger(EntrenadorService.class);
    //private IDao<T> idao;
    //constructor del servicio con la instanciacion del IDao

    @Override
    public List<Entrenador> listarEntrenadores() {
        return Arrays.asList(new Entrenador("Simon"), new Entrenador("Pablo"), new Entrenador("Lionel"));
    }
}
