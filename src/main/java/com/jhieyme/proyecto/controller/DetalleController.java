package com.jhieyme.proyecto.controller;

import com.jhieyme.proyecto.constants.MensajeConst;
import com.jhieyme.proyecto.entity.DetalleVenta;
import com.jhieyme.proyecto.service.DetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/detalles", produces = MediaType.APPLICATION_JSON_VALUE)
public class DetalleController {

    private final DetalleService detalleService;

    @GetMapping(path = "/listarDetalle")
    public ResponseEntity<Object> getDetalle(){
        List<DetalleVenta> detalleList = detalleService.findAllDetalle();
        return ResponseEntity.status(HttpStatus.OK).body(detalleList);
    }

    @PostMapping(path = "/crearDetalle")
    public ResponseEntity<Object> postVenta(@RequestBody DetalleVenta detalle){
        detalleService.save(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body("¡Detalle de venta generada correctamente!");
    }

    @PutMapping(path = "/actualizarDetalle/{id}")
    public ResponseEntity<Object> putDetalle(@PathVariable Long id, @RequestBody DetalleVenta detalle){
        DetalleVenta detalleEncontrado = detalleService.findById(id);
        if (detalleEncontrado != null){
            detalleEncontrado.setCantidad(detalle.getCantidad());
            detalleEncontrado.setPrecio(detalle.getPrecio());
            detalleEncontrado.setSub_total(detalle.getSub_total());
            detalleEncontrado.setVenta(detalle.getVenta());
            detalleEncontrado.setProducto(detalle.getProducto());
            detalleService.update(detalleEncontrado);
            return ResponseEntity.status(HttpStatus.OK).body("Detalle de venta actualizada correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MensajeConst.NO_ENC0NTRADO);
    }

    @DeleteMapping(path = "/eliminarDetalle/{id}")
    public ResponseEntity<Object> deleteDetalle(@PathVariable Long id){
        DetalleVenta detalleEncontrado = detalleService.findById(id);
        if (detalleEncontrado != null){
            detalleService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Detalle de venta eliminada correctamente!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MensajeConst.NO_ENC0NTRADO);
    }
}
