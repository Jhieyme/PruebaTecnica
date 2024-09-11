package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.entity.DetalleVenta;

import java.util.List;

public interface DetalleService {

    List<DetalleVenta> findAllDetalle();
    DetalleVenta findById(Long id);
    void save(DetalleVenta detalle);
    void update(DetalleVenta detalle);
    void delete(Long id);
}