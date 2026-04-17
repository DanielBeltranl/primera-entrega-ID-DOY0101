package com.example.producto.service;


import com.example.producto.model.Producto;
import com.example.producto.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){

        return productoRepository.findAll();
    }

    public Producto buscarId(String id){

        return productoRepository.findById(id).get();

    }


    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public void eliminarProducto(String id){
        productoRepository.deleteById(id);
    }



}
