package kz.medet.idrishmedethw24.converter;

import kz.medet.idrishmedethw24.dto.ProductDto;
import kz.medet.idrishmedethw24.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }
}
