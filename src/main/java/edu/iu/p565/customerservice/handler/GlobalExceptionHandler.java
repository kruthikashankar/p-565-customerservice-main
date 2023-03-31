//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package edu.iu.p565.customerservice.handler;

import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity<?> handleException(IllegalStateException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleException(MethodArgumentNotValidException exception) {
        String errorMessages = (String)exception.getBindingResult().getFieldErrors().stream().map((error) -> {
            return error.getDefaultMessage();
        }).collect(Collectors.joining(","));
        return ResponseEntity.badRequest().body(errorMessages);
    }
}
