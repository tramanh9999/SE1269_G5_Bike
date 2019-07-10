package group5.BikeAPI.BikeHiringAPI.spring.ExceptionHandle;

import group5.BikeAPI.BikeHiringAPI.spring.domain.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(group5.BikeAPI.BikeHiringAPI.spring.ExceptionHandle.ResourseNotFoundException.class)
    public ResponseEntity<?> resourseNotFoundException(ResourseNotFoundException ex, WebRequest request) {
        ErrorDetail ed = new ErrorDetail(ex.getMessage(), request.getDescription(false), new Date() );
        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception ex, WebRequest request) {
        ErrorDetail ed = new ErrorDetail(ex.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
