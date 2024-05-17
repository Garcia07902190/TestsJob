package com.garcia.testshop.entity;


import jakarta.persistence.*;

import java.io.Serializable;

/**
 * The type Product.
 */
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

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets precio.
     *
     * @return the precio
     */
    public long getPrecio() {
        return precio;
    }

    /**
     * Sets precio.
     *
     * @param precio the precio
     */
    public void setPrecio(long precio) {
        this.precio = precio;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
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
