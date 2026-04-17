package com.example.producto.controller;


import com.example.producto.model.Producto;
import com.example.producto.repository.ProductoRepository;
import com.example.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listAL () {

        List<Producto> productos = productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Producto> agregarProducto (@RequestBody Producto producto) {
        Producto prod1 = productoService.guardarProducto(producto);
        if(prod1==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(prod1);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Producto> buscarProducto (@PathVariable String id) {
        Producto prod = productoService.buscarId(id);
        return ResponseEntity.ok(prod);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Producto> actualizarProducto (@RequestBody Producto producto,@PathVariable String id) {

        Producto prod = productoService.buscarId(id);

        try {
            if (prod != null) {

                prod.setId_fruta(id);
                prod.setNombre(producto.getNombre());
                prod.setPrecio(producto.getPrecio());
                prod.setDescripcion(producto.getDescripcion());
                prod.setStock(producto.getStock());


            }
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(prod);

    }



    @DeleteMapping("borrar/{id}")
    public ResponseEntity<Producto> borrarProducto (@PathVariable String id) {

        productoService.eliminarProducto(id);
        return ResponseEntity.ok().build();

    }




}
