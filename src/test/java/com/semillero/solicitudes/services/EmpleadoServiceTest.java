package com.semillero.solicitudes.services;


import com.semillero.solicitudes.persistence.EmpleadoRepository;
import com.semillero.solicitudes.persistence.entities.EmpleadoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceTest {

    @InjectMocks
    private EmpleadoService empleadoService;
    @Mock
    private EmpleadoRepository empleadoRepository;

    @BeforeEach
    public void setup(){
        empleadoService = new EmpleadoService(empleadoRepository);
    }

    @Test
    public void cuando_el_repositorio_responde_se_espera_una_lista_de_tamaño_mayor_a_cero(){
        List<EmpleadoEntity> empleados = new ArrayList<>();
        EmpleadoEntity empleado = new EmpleadoEntity();
        empleados.add(empleado);
        Mockito.when(empleadoRepository.findAll()).thenReturn(empleados);
        List<EmpleadoEntity> response = empleadoService.getAll();
        Assertions.assertTrue(response.size() > 0);
    }

    @Test
    public void cuando_el_repositorio_falla_y_espera_una_lista_vacia(){
        try {
            empleadoRepository.findAll();
        }catch (Exception e){
            List<EmpleadoEntity> response= empleadoService.getAll();
            Assertions.assertTrue(response.isEmpty());
        }
    }

    @Test
    public void cuando_el_repositorio_agrega_un_nuevo_empleado_y_devuelve_el_objeto_empleado(){
        EmpleadoEntity empleado = new EmpleadoEntity();
        Mockito.when(empleadoRepository.save(empleado)).thenReturn(empleado);
        EmpleadoEntity response = empleadoService.saveEmployee(empleado);
        Assertions.assertEquals(empleado, response);
    }

    @Test
    public void cuando_el_repositorio_no_agrega_un_nuevo_empleado(){
        EmpleadoEntity empleado = new EmpleadoEntity();
        Mockito.when(empleadoRepository.save(empleado)).thenThrow(new RuntimeException("No se puede guardar el nuevo empleado"));
        try {
            EmpleadoEntity response = empleadoService.saveEmployee(empleado);
            Assertions.fail("Se esperaba que el método saveEmployee lanzara una excepción");
        } catch (RuntimeException e) {
            Assertions.assertEquals("No se puede guardar el nuevo empleado", e.getMessage());
        }
    }
}
