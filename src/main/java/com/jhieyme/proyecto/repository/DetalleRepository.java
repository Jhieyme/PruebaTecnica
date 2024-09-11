package com.jhieyme.proyecto.repository;

import com.jhieyme.proyecto.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleVenta, Long> {
}
