package com.semillero.solicitudes.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_usuario")
    private int id;

    @Column(name = "ds_usaurio", length = 100)
    private String usaurio;

    @Column(name = "fe_fecha_creacion")
    private LocalDate fecha_creacion;

    @Column(name = "ds_activo", length = 10)
    private String activo;

    @Column(name = "ds_contraseña", length = 100)
    private String contrasena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "nm_id_empleado")
    private EmpleadoEntity id_empleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "nm_rol")
    private RolEntity id_rol;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private List<SolicitudEntity> solicitudes;
}
