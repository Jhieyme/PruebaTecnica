package com.jhieyme.proyecto.dto;

import com.jhieyme.proyecto.entity.Venta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String nombres;

    private String apellidos;

    private String nro_documento;

    private String email;

    private Date create_at;

    private Set<Venta> venta = new HashSet<>();
}
