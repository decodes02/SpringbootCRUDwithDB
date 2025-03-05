package com.revision.CRUDwithDB.Controller;


import com.revision.CRUDwithDB.Model.Product;
import com.revision.CRUDwithDB.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return productService.getProductById(prodId);
    }

    @PostMapping
    public void addProduct(@RequestBody Product prod){
        productService.addProduct(prod);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product prod){
        productService.updateProduct(prod);
    }

    @DeleteMapping("/{prodId}")
    public String deleteProduct(@PathVariable int prodId){
        return productService.deleteProduct(prodId);
    }
}
