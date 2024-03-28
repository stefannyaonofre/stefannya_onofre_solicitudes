package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "rol_usuario")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_rol")
    private int id;

    @Column(name = "ds_rol", length = 60)
    private String rol;

    @Column(name = "fe_fecha_creacion")
    private LocalDate fecha_creacion;
}
