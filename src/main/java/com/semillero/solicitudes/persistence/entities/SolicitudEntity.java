package com.semillero.solicitudes.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "solicitud_vaciones")
public class SolicitudEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_solicitud")
    private int id;

    @Column(name = "nm_dias_solicita")
    private int dias_solicitado;

    @Column(name = "fe_fecha_inicio")
    private LocalDate fecha_inicio;

    @Column(name = "fe_fecha_fin")
    private LocalDate fecha_fin;

    @Column(name = "fe_fecha_retorna")
    private LocalDate fecha_retorno;

    @Column(name = "ds_estado", length = 10)
    private String estado;

    @Column(name = "ds_observaciones", length = 60)
    private String observaciones;

    @Column(name = "fe_fecha_creacion")
    private LocalDate fecha_creacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "nm_id_usuario")
    private UsuarioEntity usuario;

}
