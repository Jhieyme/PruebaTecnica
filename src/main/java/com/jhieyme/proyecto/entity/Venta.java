package com.jhieyme.proyecto.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @Column
    private String serie;

    @Column
    private String numero;

    @Column
    private Double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "id_detalle", cascade = CascadeType.ALL)
    private Set<DetalleVenta> detalle = new HashSet<>();

}