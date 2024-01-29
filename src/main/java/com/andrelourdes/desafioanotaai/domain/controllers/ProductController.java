package com.andrelourdes.desafioanotaai.domain.controllers;

import com.andrelourdes.desafioanotaai.domain.category.Category;
import com.andrelourdes.desafioanotaai.domain.category.CategoryDTO;
import com.andrelourdes.desafioanotaai.domain.product.Product;
import com.andrelourdes.desafioanotaai.domain.product.ProductDTO;
import com.andrelourdes.desafioanotaai.domain.services.CategoryService;
import com.andrelourdes.desafioanotaai.domain.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service){

        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData){
        Product newProduct =  this.service.insert(productData);
        return ResponseEntity.ok().body(newProduct);

    }

    @GetMapping
    ResponseEntity<List<Product>> getAll(){
        List<Product> products = this.service.getAll();
        return ResponseEntity.ok().body(products);

    }
    @PutMapping("-/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO cproductData){
        Product updatedProduct = this.service.update(id, cproductData);
        return ResponseEntity.ok().body(updatedProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

