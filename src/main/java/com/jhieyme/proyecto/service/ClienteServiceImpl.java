package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.entity.Cliente;
import com.jhieyme.proyecto.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
