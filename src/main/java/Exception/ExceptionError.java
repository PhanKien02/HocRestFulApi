package Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionError extends ResponseEntityExceptionHandler {
     @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static ErrorMessage handlerNotFoundException(NotFoundException ex,
     WebRequest req) {
     // Log err

    return new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
     }

     // Xử lý tất cả các exception chưa được khai báo
     @ExceptionHandler(Exception.class)
     @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
     public static ErrorMessage handlerException(Exception ex, WebRequest req) {
    // /Log err
     return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
     }

    
}
