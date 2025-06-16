package com.Prueba.Prueba.Service;

import com.Prueba.Prueba.Entity.BodegaProducto;
import com.Prueba.Prueba.Repository.BodegaRepository;
import com.Prueba.Prueba.Repository.InventarioRepository;
import com.Prueba.Prueba.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodegaProductoService {
    @Autowired
    private InventarioRepository inventarioRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private BodegaRepository bodegaRepository;


    public List<BodegaProducto> buscarProducto(String nombre) {
        return inventarioRepository.buscarPorNombreProducto(nombre);
    }

    public void postProducto(Long ProductID, Long BodegaId, int cantidad){
        BodegaProducto bodega= new BodegaProducto();
        bodega.setProducto(productoRepository.findById(ProductID).orElseThrow());
        bodega.setBodega(bodegaRepository.findById(BodegaId).orElseThrow());
        bodega.setCantidad(cantidad);
        inventarioRepository.save(bodega);
    }
}
