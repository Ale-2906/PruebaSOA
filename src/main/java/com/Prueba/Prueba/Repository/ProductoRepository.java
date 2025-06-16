package com.Prueba.Prueba.Repository;

import com.Prueba.Prueba.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
