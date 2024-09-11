package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.entity.Producto;
import com.jhieyme.proyecto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void update(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }
}
