package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.SolicitudRepository;
import com.semillero.solicitudes.persistence.entities.SolicitudEntity;
import com.semillero.solicitudes.services.interfaces.ISolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService implements ISolicitud {
    SolicitudRepository solicitudRepository;

    @Autowired
    public SolicitudService (SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public List<SolicitudEntity> getAll() {
        return solicitudRepository.findAll();
    }
}
