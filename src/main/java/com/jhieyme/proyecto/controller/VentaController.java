package com.jhieyme.proyecto.controller;

import com.jhieyme.proyecto.entity.Venta;
import com.jhieyme.proyecto.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/ventas", produces = MediaType.APPLICATION_JSON_VALUE)
public class VentaController {

    private final VentaService ventaService;

    @GetMapping(path = "/listarVenta")
    public ResponseEntity<Object> getVenta(){
        List<Venta> ventaList = ventaService.findAllVentas();
        return ResponseEntity.status(HttpStatus.OK).body(ventaList);
    }

    @PostMapping(path = "/crearVenta")
    public ResponseEntity<Object> postVenta(@RequestBody Venta venta){
        ventaService.save(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body("¡Venta generada correctamente!");
    }

    @PutMapping(path = "/actualizarVenta/{id}")
    public ResponseEntity<Object> putVenta(@PathVariable Long id, @RequestBody Venta venta){
        Venta ventaEncontrada = ventaService.findById(id);
        if (ventaEncontrada != null){
            ventaEncontrada.setFecha(venta.getFecha());
            ventaEncontrada.setSerie(venta.getSerie());
            ventaEncontrada.setNumero(venta.getNumero());
            ventaEncontrada.setTotal(venta.getTotal());
            ventaEncontrada.setCliente(venta.getCliente());
            ventaService.update(ventaEncontrada);
            return ResponseEntity.status(HttpStatus.OK).body("Venta actualizada correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron resultados");
    }

    @DeleteMapping(path = "/eliminarVenta/{id}")
    public ResponseEntity<Object> deleteVenta(@PathVariable Long id){
        Venta ventaEcontrada = ventaService.findById(id);
        if (ventaEcontrada != null){
            ventaService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Venta eliminada correctamente!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron resultados");
    }
}
