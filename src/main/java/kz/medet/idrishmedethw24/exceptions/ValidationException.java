package kz.medet.idrishmedethw24.exceptions;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ValidationException extends RuntimeException{

    List<String> errorsFieldMessages;

    public ValidationException(List<String> errorsFieldMessages){
        super(errorsFieldMessages.stream().collect(Collectors.joining(", ")));
        this.errorsFieldMessages = errorsFieldMessages;
    }
}
