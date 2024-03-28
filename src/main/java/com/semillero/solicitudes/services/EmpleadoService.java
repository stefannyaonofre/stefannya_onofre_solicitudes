package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.EmpleadoRepository;
import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import com.semillero.solicitudes.services.interfaces.IEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleado {
    EmpleadoRepository empleadoRepository;
    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<EmpleadoEntity>getAll() {
        return empleadoRepository.findAll();
    }

    public EmpleadoEntity saveEmployee(EmpleadoEntity empleado){
            return empleadoRepository.save(empleado);
    }

    public Optional<EmpleadoEntity> getById(Integer id){
        return empleadoRepository.findById(id);
    }

    public EmpleadoEntity updateById(EmpleadoEntity request, Integer id){
        EmpleadoEntity empleado = empleadoRepository.findById(id).get();

        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());
        empleado.setEstado_empleado(request.getEstado_empleado());
        empleado.setCargo(request.getCargo());
        empleado.setDocumento(request.getDocumento());
        empleado.setDireccion(request.getDireccion());
        empleado.setSupervisor(request.getSupervisor());
        empleado.setTelefono(request.getTelefono());
        empleado.setTipo_contrato(request.getTipo_contrato());
        empleado.setFecha_ingreso(request.getFecha_ingreso());
        empleado.setFecha_retiro(request.getFecha_retiro());
        empleado.setTipo_documento(request.getTipo_documento());

        empleadoRepository.save(empleado);

        return empleado;
    }
}
