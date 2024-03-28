package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import com.semillero.solicitudes.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping(value = "/getEmployees")
    public List<EmpleadoEntity> getEmployee(){
        return this.empleadoService.getAll();
    }

    @PostMapping(value = "/saveEmployees")
    public EmpleadoEntity saveEmployee(@RequestBody EmpleadoEntity empleado){
        return this.empleadoService.saveEmployee(empleado);
    }

    @GetMapping(path = "/{id}")
    public Optional<EmpleadoEntity> getEmployeeById(@PathVariable("id") Integer id){
        return this.empleadoService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public EmpleadoEntity updateEmployeeById(@RequestBody EmpleadoEntity request,@PathVariable("id") Integer id){
        return this.empleadoService.updateById(request, id);
    }

}
