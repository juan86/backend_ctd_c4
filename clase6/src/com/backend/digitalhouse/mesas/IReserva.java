package com.backend.digitalhouse.mesas;

public interface IReserva {
    void buscar(String fechaIda, String fechaVuelta, String origen, String destino);
    void buscar(String fechaEntrada, String fechaSalida, String ciudad);
}
