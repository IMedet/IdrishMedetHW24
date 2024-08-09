package kz.medet.idrishmedethw24.service;

import kz.medet.idrishmedethw24.converter.ProductConverter;
import kz.medet.idrishmedethw24.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private List<ProductDto> cart = new ArrayList<>(100);

    private final ProductService productService;
    private final ProductConverter productConverter;


    public void addToCart(int productId) {
        ProductDto product = productConverter.entityToDto(productService.getProductById(productId));
        cart.add(product);
    }

    public void removeFromCart(int productId) {
        cart.removeIf(product -> product.getId() == productId);
    }

    public List<ProductDto> viewCart() {
        return new ArrayList<>(cart);
    }

    public void clearCart() {
        cart.clear();
    }
}
