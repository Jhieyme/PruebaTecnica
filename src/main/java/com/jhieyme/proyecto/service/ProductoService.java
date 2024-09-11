package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAllProductos();
    Producto findById(Integer id);
    void save(Producto producto);
    void update(Producto producto);
    void delete(Integer id);
}
