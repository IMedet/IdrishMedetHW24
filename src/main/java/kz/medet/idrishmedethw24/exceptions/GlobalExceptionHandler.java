package kz.medet.idrishmedethw24.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<FieldValidationError> catchFieldValidationException(ValidationException e){
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new FieldValidationError(e.getErrorsFieldMessages()), HttpStatus.BAD_REQUEST);
    }
}
