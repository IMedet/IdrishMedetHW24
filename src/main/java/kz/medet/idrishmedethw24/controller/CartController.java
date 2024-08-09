package kz.medet.idrishmedethw24.controller;

import kz.medet.idrishmedethw24.dto.ProductDto;
import kz.medet.idrishmedethw24.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/cart/add/{id}")
    public void addToCart(@PathVariable int id) {
        cartService.addToCart(id);
    }

    @PostMapping("/cart/remove/{id}")
    public void removeFromCart(@PathVariable int id) {
        cartService.removeFromCart(id);
    }

    @PostMapping("/cart/clear")
    public void clearCart() {
        cartService.clearCart();
    }

    @GetMapping("/cart")
    public List<ProductDto> getCart() {
        return cartService.viewCart();
    }
}
