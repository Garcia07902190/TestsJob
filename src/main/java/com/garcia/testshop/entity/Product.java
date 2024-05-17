package com.garcia.testshop.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "Product_shop")
public class Product  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "product_name", nullable = false, length = 80)
    private String nombre;

    @Column(name = "product_price", nullable = false )
    private Long precio;

    @Column (name = "product_description", nullable = false, length = 100)
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", description='" + description + '\'' +
                '}';
    }
}
