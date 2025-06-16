package com.Prueba.Prueba.Controller;

import com.Prueba.Prueba.Entity.BodegaProducto;
import com.Prueba.Prueba.Repository.BodegaRepository;
import com.Prueba.Prueba.Repository.ProductoRepository;
import com.Prueba.Prueba.Service.BodegaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InventarioController {
    @Autowired
    private BodegaProductoService service;
    @Autowired
    private ProductoRepository productorepository;
    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/")
    public String index(){
        return "buscar";

    }
    @PostMapping("/buscar")
    public String buscar(@RequestParam("nombre") String nombre, Model model){
        List<BodegaProducto> resultado = service.buscarProducto(nombre);
        model.addAttribute("resultados", resultado);
        return "resultados";
    }

    @GetMapping("/nuevo")
    public String mostrar(Model model){
        model.addAttribute("productos", productorepository.findAll() );
        model.addAttribute("bodegas", bodegaRepository.findAll() );
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String postProducto(@RequestParam Long productoId,@RequestParam Long bodegaId, @RequestParam int cantidad){
        service.postProducto(productoId,bodegaId,cantidad);
        return "redirect:/";
    }
}
