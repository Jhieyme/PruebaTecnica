package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.dto.ClienteDTO;
import com.jhieyme.proyecto.entity.Cliente;

import java.util.List;

public interface ClienteService {

//    List<Cliente> findAll();
    List<ClienteDTO> findAll();

    Cliente findById(Long id);
//    void save(Cliente cliente);

    void save(ClienteDTO clienteDTO);
//    void update(Cliente cliente);

    void update(Long id, ClienteDTO clienteDTO);

    void delete(Long id);

}
