package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.entity.Venta;

import java.util.List;

public interface VentaService {

    List<Venta> findAllVentas();
    Venta findById(Long id);
    void save(Venta venta);
    void update(Venta venta);
    void delete(Long id);

}
