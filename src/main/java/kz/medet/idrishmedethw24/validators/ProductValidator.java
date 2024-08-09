package kz.medet.idrishmedethw24.validators;

import kz.medet.idrishmedethw24.dto.ProductDto;
import kz.medet.idrishmedethw24.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    public void validate(ProductDto productDto){
        List<String> list = new ArrayList<>();

        if(productDto.getPrice() < 1) {
            list.add("Цена не может быть меньше 1");
        }
        if(productDto.getName().isBlank()){
            list.add("Продукт не может иметь пустое название");
        }
        if(!list.isEmpty()){
            throw new ValidationException(list);
        }
    }
}
