package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "cargos")
public class CargosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_cargo")
    private int id;

    @Column(name = "ds_cargo", length = 50)
    private String cargo;

    @Column(name = "ds_descripcion", length = 100)
    private String descripcion;

    @Column(name = "fe_fecha_creacion")
    private LocalDate fecha_creacion;

    @Column(name = "ds_activo", length = 10)
    private String activo;
}
