package com.jhieyme.proyecto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @Column
    private String descripcion;

    @Column
    private Integer cantidad;

    @Column
    private byte estado;

    @OneToMany(mappedBy = "id_detalle", cascade = CascadeType.ALL)
    private Set<DetalleVenta> detalle = new HashSet<>();

}
