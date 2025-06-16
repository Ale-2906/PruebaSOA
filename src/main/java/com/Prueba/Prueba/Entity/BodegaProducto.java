package com.Prueba.Prueba.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bodega_producto")
public class BodegaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id") // nombre de la columna en la tabla 'bodega_producto' que referencia a 'productos'
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "bodega_id") // nombre de la columna en la tabla 'bodega_producto' que referencia a 'bodegas'
    private Bodega bodega;
}
