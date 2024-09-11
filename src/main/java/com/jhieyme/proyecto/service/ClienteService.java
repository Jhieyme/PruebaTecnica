package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();
    Cliente findById(Long id);
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Long id);

}
