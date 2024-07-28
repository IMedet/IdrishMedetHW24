package kz.medet.idrishmedethw24.controller;

import kz.medet.idrishmedethw24.model.Product;
import kz.medet.idrishmedethw24.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(required = false) Integer minPrice,
                                     @RequestParam(required = false) Integer maxPrice) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getProductList(pageable, minPrice, maxPrice);
    }

    @GetMapping(value = "/products/getById/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
