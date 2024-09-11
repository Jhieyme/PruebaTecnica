package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.entity.DetalleVenta;
import com.jhieyme.proyecto.repository.DetalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleServiceImpl implements DetalleService{

    private final DetalleRepository detalleRepository;

    @Override
    public List<DetalleVenta> findAllDetalle() {
        return detalleRepository.findAll();
    }

    @Override
    public DetalleVenta findById(Long id) {
        return detalleRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DetalleVenta detalle) {
        detalleRepository.save(detalle);
    }

    @Override
    public void update(DetalleVenta detalle) {
        detalleRepository.save(detalle);
    }

    @Override
    public void delete(Long id) {
        detalleRepository.deleteById(id);
    }
}
