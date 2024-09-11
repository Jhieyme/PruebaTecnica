package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.entity.Cliente;
import com.jhieyme.proyecto.entity.Venta;
import com.jhieyme.proyecto.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService{

    private final VentaRepository ventaRepository;

    @Override
    public List<Venta> findAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta findById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void update(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void delete(Long id) {
        ventaRepository.deleteById(id);
    }

}
