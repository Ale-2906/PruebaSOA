package com.Prueba.Prueba.Repository;

import com.Prueba.Prueba.Entity.BodegaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventarioRepository extends JpaRepository<BodegaProducto, Long> {
    @Query("SELECT bp FROM BodegaProducto bp WHERE bp.producto.nombre = :nombre")
    List<BodegaProducto> buscarPorNombreProducto(@Param("nombre") String nombre);
}
