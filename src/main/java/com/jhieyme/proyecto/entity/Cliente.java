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
@Table(name = "clientes")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column
    private String nombres;

    @Column
    private String apellidos;

    @Column
    private String nro_documento;

    @Column
    private String email;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date create_at;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Venta> venta = new HashSet<>();

}
