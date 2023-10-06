package com.student.utile.exception;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler( )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> userNotFoundHandler(UserNotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("error", ex.getMessage());
        return map;
    }

    
}
