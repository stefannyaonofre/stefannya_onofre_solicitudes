package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.SolicitudEntity;
import com.semillero.solicitudes.services.SolicitudService;
import com.semillero.solicitudes.services.interfaces.ISolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

    ISolicitud solicitudService;

    @Autowired
    public ApplicationController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping(value="/health-check")
    private String healthCheck() {
        return "OK";
    }

    @GetMapping(value = "/getAll")
    private List<SolicitudEntity> getAll() {
        return this.solicitudService.getAll();
    }
}
