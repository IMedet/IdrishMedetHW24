package kz.medet.idrishmedethw24.service;

import kz.medet.idrishmedethw24.model.Product;
import kz.medet.idrishmedethw24.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getProductList(Pageable pageable, Integer minPrice, Integer maxPrice) {
        if(minPrice != null && maxPrice != null){
            return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        }else if(minPrice != null){
            return productRepository.findByPriceGreaterThanEqual(minPrice, pageable);
        } else if (maxPrice != null) {
            return productRepository.findByPriceLessThanEqual(maxPrice, pageable);
        }else {
            return productRepository.findAll(pageable);
        }
    }

    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
