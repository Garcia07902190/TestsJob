package com.garcia.testshop.service;

import com.garcia.testshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * interface de servicio  productos
 */
public interface ShopService {

    /**
     * Listar todos los productos
     *
     * @return Regresa una lista completa de productos
     */
    public List<Product> executeListAllProduct();

    /**
     * Buscar un producto
     *
     * @param id the id
     * @return Regresa el producto solicitado productos
     */
    public Optional<Product> executeGetProduct(Long id);

    /**
     * Agregar productos
     *
     * @param p the p
     * @return Obtiene mensaje de actualizacion
     */
    public String executeAddProduct(Product p);

    /**
     * Actualizar productos @param p the p
     */
    public void executeUpdateProduct(Product p);

    /**
     * Elimina el producto indicado @param id the id
     *
     * @return the string
     */
    public String executeDeleteProduct(Long id);

    /**
     * Paginacion de productos @param pagina the pagina
     *
     * @return the page
     */
    public Page<Product>  executeFindProduct(Pageable pagina);

}
