package com.jhieyme.proyecto.service;

import com.jhieyme.proyecto.dto.ClienteDTO;
import com.jhieyme.proyecto.entity.Cliente;
import com.jhieyme.proyecto.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jhieyme.proyecto.constants.MensajeConst.NO_ENC0NTRADO;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

//    @Override
//    public List<Cliente> findAll() {
//        return clienteRepository.findAll();
//    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clienteDto = clientes.stream().map(clienteDb -> {
            return ClienteDTO.builder()
                    .nombres(clienteDb.getNombres())
                    .apellidos(clienteDb.getApellidos())
                    .email(clienteDb.getEmail())
                    .nro_documento(clienteDb.getNro_documento())
                    .create_at(clienteDb.getCreate_at())
                    .venta(clienteDb.getVenta())
                    .build();
        }).collect(toList());
        return clienteDto;
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
                .nombres(clienteDTO.getNombres())
                .apellidos(clienteDTO.getApellidos())
                .email(clienteDTO.getEmail())
                .nro_documento(clienteDTO.getNro_documento())
                .create_at(clienteDTO.getCreate_at())
                .build();
        clienteRepository.save(cliente);
    }

    @Override
    public void update(Long id, ClienteDTO clienteDTO) {
        Cliente clienteEncontrado = clienteRepository.findById(id).orElse(null);
        if (clienteEncontrado != null){
            clienteEncontrado.setNombres(clienteDTO.getNombres());
            clienteEncontrado.setApellidos(clienteDTO.getApellidos());
            clienteEncontrado.setEmail(clienteDTO.getEmail());
            clienteEncontrado.setNro_documento(clienteDTO.getNro_documento());
            clienteEncontrado.setCreate_at(clienteDTO.getCreate_at());
            clienteRepository.save(clienteEncontrado);
        }
        throw new RuntimeException(NO_ENC0NTRADO);
    }

//    @Override
//    public void save(Cliente cliente) {
//        clienteRepository.save(cliente);
//    }



//    @Override
//    public void update(Cliente cliente) {
//        clienteRepository.save(cliente);
//    }

    @Override
    public void delete(Long id) {
        Cliente clienteEncontrado = clienteRepository.findById(id).orElse(null);
        if (clienteEncontrado != null){
            clienteRepository.deleteById(id);
        }
        throw new RuntimeException(NO_ENC0NTRADO);

    }
}
