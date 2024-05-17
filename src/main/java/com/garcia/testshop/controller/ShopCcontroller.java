package com.garcia.testshop.controller;

import com.garcia.testshop.email.SendMailService;
import com.garcia.testshop.entity.Product;
import com.garcia.testshop.execeptions.ResourceNotFoundException;
import com.garcia.testshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
@CrossOrigin(origins = "*")
public class ShopCcontroller {

    @Autowired
    private ShopService serviceSh;
    @Autowired
    private SendMailService sendMailService;

    /**
     * Obtener todos los productos
     */
    @GetMapping("/productos")
    public ResponseEntity<List<Product>> executeListProduct(){
        List<Product> response= null;
        try {
            response= serviceSh.executeListAllProduct();
         }catch (Exception ex){
             new ResourceNotFoundException("No se encontraron los productos");
         }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    /** Crear un nuevo producto*/
    @PostMapping("/create")
    public ResponseEntity<?> executeCreateProduct(@RequestBody Product product){
        if (product.getNombre()!=null && product.getDescription()!=null){
            product.getPrecio();
            if(product.getPrecio()>0L){
                serviceSh.executeAddProduct(product);
                sendMailService.executeSendEmail(
                        "luisgarcia_0790@hotmail.es",
                        "Creacion de producto nuevo",
                        "Creacion de producto nuevo" +
                                new Date()+"producto creado "+product.getNombre()+" con valor de "+product.getPrecio());
                return ResponseEntity.status(HttpStatus.CREATED).body("Succes");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El precio del producto debe ser mayo a Cero");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("AGREGAR LOS PARAMETROS FALTANTES");
    }

    /**consulta por numero de pagina*/
    @GetMapping("/pag/{numpag}")
    public  ResponseEntity<?> executeGetPageProduct(@RequestParam(value = "numpag",
            defaultValue = "0")Integer numpag){
        if(numpag==null){
            numpag=1;
        }
        final Pageable pagData= PageRequest.of(numpag,5);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(serviceSh.executeFindProduct(pagData));
    }

    /**Eliminar producto*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> executeDeleteProduct(@PathVariable (name = "id")Long id){
        ResponseEntity<String> request = null;
        final Optional<Product> data= serviceSh.executeGetProduct(id);
        if (data!=null){
           String response= serviceSh.executeDeleteProduct(id);
            request= ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }else {
            ResponseEntity.status(HttpStatus.ACCEPTED).body("No se encontro el producto");
        }
        return  request;
    }


    /**Actualizar producto*/
    @PostMapping("/update/")
    public  ResponseEntity<?> executeUpdateProduct(@RequestBody Product product){
      try {
            if (product.getNombre()!=null && product.getDescription()!=null){
                final Optional<Product> data= serviceSh.executeGetProduct(product.getId());
                if (!data.isEmpty()){
                    serviceSh.executeUpdateProduct(product);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Succes");
                }
            }
      }catch (Exception ex){
          new ResourceNotFoundException("No se encontraron los productos");
      }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO EXISTE REGISTRO");
    }

}
