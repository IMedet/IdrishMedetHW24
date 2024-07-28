package kz.medet.idrishmedethw24.repository;

import kz.medet.idrishmedethw24.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByPriceBetween(Integer minPrice, Integer maxPrice, Pageable pageable);
    Page<Product> findByPriceGreaterThanEqual(Integer minPrice, Pageable pageable);
    Page<Product> findByPriceLessThanEqual(Integer maxPrice, Pageable pageable);


//    private int amountId = 4;
//
//    List<Product> productList = new ArrayList<>(List.of(
//            new Product(1, "Bread", 200),
//            new Product(2, "Milk", 350),
//            new Product(3, "Coffee", 900)
//    ));
//
//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public Product addProduct(Product product) {
//        product.setId(amountId);
//        amountId++;
//
//        productList.add(product);
//        return product;
//    }
//
//    public Product getProductById(int id) {
//        for (Product product : productList) {
//            if(product.getId()==(id)){
//                return product;
//            }
//        }
//
//        return null;
//    }
//
//    public void deleteById(int id) {
//        productList.removeIf(s->s.getId()==id);
//    }
}