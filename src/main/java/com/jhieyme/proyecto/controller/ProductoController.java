package com.jhieyme.proyecto.controller;

import com.jhieyme.proyecto.constants.MensajeConst;
import com.jhieyme.proyecto.entity.Producto;
import com.jhieyme.proyecto.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping(path = "/listarProducto")
    public ResponseEntity<Object> getProducto(){
        List<Producto> productos = productoService.findAllProductos();
        return ResponseEntity.status(HttpStatus.OK).body(productos);
    }

    @PostMapping(path = "/crearProducto")
    public ResponseEntity<Object> postProducto(@RequestBody Producto producto){
        productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto creado correctamente");
    }

    @PutMapping(path = "/actualizarProducto/{id}")
    public ResponseEntity<Object> putProducto(@PathVariable Integer id, @RequestBody Producto producto){
        Producto productoEncontrado = productoService.findById(id);
        if (productoEncontrado != null){
            productoEncontrado.setDescripcion(producto.getDescripcion());
            productoEncontrado.setCantidad(producto.getCantidad());
            productoEncontrado.setEstado(producto.getEstado());
            productoService.update(productoEncontrado);
            return ResponseEntity.status(HttpStatus.OK).body("Producto actualizado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MensajeConst.NO_ENC0NTRADO);
    }

    @DeleteMapping(path = "/eliminarProducto/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Integer id){
        Producto productoEncontrado = productoService.findById(id);
        if (productoEncontrado != null){
            productoService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MensajeConst.NO_ENC0NTRADO);
    }

}
