package kz.medet.idrishmedethw24.controller;

import kz.medet.idrishmedethw24.converter.ProductConverter;
import kz.medet.idrishmedethw24.dto.ProductDto;
import kz.medet.idrishmedethw24.service.ProductService;
import kz.medet.idrishmedethw24.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    @GetMapping(value = "/products")
    public Page<ProductDto> getProducts(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(required = false) Integer minPrice,
                                     @RequestParam(required = false) Integer maxPrice) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getProductList(pageable, minPrice, maxPrice)
                .map(p->new ProductDto(p.getId(), p.getName(), p.getPrice()));
    }

    @GetMapping(value = "/products/getById/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productConverter.entityToDto(productService.getProductById(id));
    }

    @PostMapping(value = "/products")
    public void addProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        productService.addProduct(productConverter.dtoToEntity(productDto));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
