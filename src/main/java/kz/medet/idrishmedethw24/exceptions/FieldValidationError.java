package kz.medet.idrishmedethw24.exceptions;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FieldValidationError {
    private List<String> errorFieldMessage;

    public FieldValidationError(List<String> errorFieldMessage){
        this.errorFieldMessage = errorFieldMessage;
    }
}
