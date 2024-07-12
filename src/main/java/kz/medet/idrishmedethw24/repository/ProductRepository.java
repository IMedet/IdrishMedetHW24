package kz.medet.idrishmedethw24.repository;

import kz.medet.idrishmedethw24.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> productList = new ArrayList<>(List.of(
            new Product(1, "Bread", 200),
            new Product(2, "Milk", 350),
            new Product(3, "Coffee", 900)
    ));

    public List<Product> getProductList() {
        return productList;
    }

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if(product.getId()==(id)){
                return product;
            }
        }

        return null;
    }

    public void deleteById(int id) {
        productList.removeIf(s->s.getId()==id);
    }
}