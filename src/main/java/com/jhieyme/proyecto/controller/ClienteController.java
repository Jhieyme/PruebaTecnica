package com.jhieyme.proyecto.controller;

import com.jhieyme.proyecto.dto.ClienteDTO;
import com.jhieyme.proyecto.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    private final ClienteService service;

//    @GetMapping(path = "/listar")
//    public ResponseEntity<Object> getCliente(){
//        List<Cliente> clientes = service.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(clientes);
//    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ClienteDTO>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

//    @PostMapping(path = "/crear")
//    public ResponseEntity<Object> postCliente(@RequestBody Cliente cliente){
//        service.save(cliente);
//        return ResponseEntity.status(HttpStatus.CREATED).body("¡Cliente creado correctamente!");
//    }

    @PostMapping(path = "/crear")
    public ResponseEntity<Object> postCliente(@RequestBody ClienteDTO clienteDTO){
        service.save(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("¡Cliente creado correctamente!");
    }

//    @PutMapping(path = "/actualizar/{id}")
//    public ResponseEntity<Object> putCliente(@PathVariable Long id, @RequestBody Cliente cliente){
//        Cliente clienteEncontrado = service.findById(id);
//        if (clienteEncontrado != null){
//            clienteEncontrado.setNombres(cliente.getNombres());
//            clienteEncontrado.setApellidos(cliente.getApellidos());
//            clienteEncontrado.setNro_documento(cliente.getNro_documento());
//            clienteEncontrado.setEmail(cliente.getEmail());
//            clienteEncontrado.setCreate_at(cliente.getCreate_at());
//            service.update(clienteEncontrado);
//            return ResponseEntity.status(HttpStatus.OK).body("¡Cliente actualizado correctamente!");
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MensajeConst.NO_ENC0NTRADO);
//    }

    @PutMapping(path = "/actualizar/{id}")
    public ResponseEntity<Object> putCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        try {
            service.update(id, clienteDTO);
            return ResponseEntity.status(HttpStatus.OK).body("¡Cliente actualizado correctamente!");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

//    @DeleteMapping(path = "/eliminar/{id}")
//    public ResponseEntity<Object> deleteCliente(@PathVariable Long id){
//        Cliente clienteEncontrado = service.findById(id);
//        if (clienteEncontrado != null){
//            service.delete(id);
//            return ResponseEntity.status(HttpStatus.OK).body("¡Cliente eliminado correctamente!");
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NO_ENC0NTRADO);
//    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable Long id){
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("¡Cliente eliminado correctamente!");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

}
