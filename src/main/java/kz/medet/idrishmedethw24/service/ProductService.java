package kz.medet.idrishmedethw24.service;

import kz.medet.idrishmedethw24.model.Product;
import kz.medet.idrishmedethw24.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    public Product addProduct(Product product) {
        productRepository.addProduct(product);
        return product;
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
