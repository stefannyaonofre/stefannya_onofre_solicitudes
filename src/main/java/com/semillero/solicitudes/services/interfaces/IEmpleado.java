package com.semillero.solicitudes.services.interfaces;

import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;

import java.util.List;

public interface IEmpleado {
    List<EmpleadoEntity> getAll();
}
