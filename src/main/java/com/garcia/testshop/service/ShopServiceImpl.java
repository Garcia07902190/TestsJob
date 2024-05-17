package com.garcia.testshop.service;

import com.garcia.testshop.entity.Product;
import com.garcia.testshop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Shop service.
 */
@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopRepository repositoryShop;


    @Override
    public List<Product> executeListAllProduct() {
        return repositoryShop.findAll();
    }

    @Override
    public Optional<Product> executeGetProduct(Long id) {
        return repositoryShop.findById(id);
    }

    @Override
    public String executeAddProduct(Product p) {
        repositoryShop.save(p);
        return "Success";
    }

    @Override
    public void executeUpdateProduct(Product p) {
        repositoryShop.save(p);
    }

    @Override
    public String executeDeleteProduct(Long id) {
        repositoryShop.deleteById(id);
        return "Succes";
    }

    @Override
    public Page<Product> executeFindProduct(Pageable pagina) {
        return repositoryShop.findAll(pagina);
    }

}
