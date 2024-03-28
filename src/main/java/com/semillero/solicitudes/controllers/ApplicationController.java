package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.SolicitudEntity;
import com.semillero.solicitudes.services.SolicitudService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class ApplicationController {


    @Autowired
    public SolicitudService solicitudService;

   /* @GetMapping(value="/health-check")
    private String healthCheck() {
        return "OK";
    }*/

    @GetMapping(value = "/getRequests")
    public List<SolicitudEntity> getRequests() {
        List<SolicitudEntity> response = this.solicitudService.getAll();
        return response;
    }

    @PostMapping(value = "/saveRequests")
    public SolicitudEntity saveRequests(@RequestBody SolicitudEntity solicitud){
       /* entities = return new SolicitudEntity<>(entities, HttpStatus.SC_OK);*/
        return this.solicitudService.saveRequests(solicitud);
    }
}
