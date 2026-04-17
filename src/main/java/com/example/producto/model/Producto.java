package com.example.producto.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto {

    @Id
    @Column(name = "id_producto", nullable = false)
    private String id_fruta;

    @Column(name = "nombre_producto")
    private String nombre;

    @Column(name = "precio")
    private int precio;

    @Column(name ="categoria")
    protected String categoria;

    @Column(name = "stock")
    private int stock;

    @Column (name = "descripcion")
    private String descripcion;


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getId_fruta() {
        return id_fruta;
    }

    public void setId_fruta(String id_fruta) {
        this.id_fruta = id_fruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
