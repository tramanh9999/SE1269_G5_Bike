package group5.BikeAPI.BikeHiringAPI.spring.ExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestExeption extends Exception{
    private static final long serialVersionUID = 2L;
    public BadRequestExeption(String message){
        super(message);
    }
//todo: to be develope more Request exception
}
