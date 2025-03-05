package com.revision.CRUDwithDB.Service;


import com.revision.CRUDwithDB.Model.Product;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "IPad", 80000),
            new Product(103, "MacBook", 120000)));


    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().orElse(new Product(100, "No Item", 0));
    }

    public void addProduct(Product prod){
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int index = 0;
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getProdId()==prod.getProdId())
                index = i;
        }
        products.set(index, prod);
    }

    public String deleteProduct(int prodId) {
        int index = 0, flag = 0;
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getProdId()==prodId) {
                index = i;
                flag = 1;
            }
        }
        if(flag==1){
            products.remove(index);
            return "Product deleted";
        }
        return "Product Not Found";
    }
}
