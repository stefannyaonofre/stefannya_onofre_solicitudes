package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "empleado")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_empleado")
    private int id;

    @Column(name = "nm_documento")
    private int documento;

    @Column(name = "ds_tipo_documento", length = 30)
    private String tipo_documento;

    @Column(name = "ds_nombre", length = 30)
    private String nombre;

    @Column(name = "ds_apellido", length = 30)
    private String apellido;

    @Column(name = "ds_telefono", length = 14)
    private String telefono;

    @Column(name = "ds_direccion", length = 60)
    private String direccion;

    @Column(name = "fe_fecha_ingreso")
    private LocalDate fecha_ingreso;

    @Column(name = "fe_fecha_retiro")
    private LocalDate fecha_retiro;

    @Column(name = "ds_tipo_contrato", length = 20)
    private String tipo_contrato;

    @Column(name = "ds_estado_empleado", length = 10)
    private String estado_empleado;

    @Column(name = "nm_supervisor_inmediato")
    private int supervisor;

    @Column(name = "nm_cargo")
    private int cargo;

}
