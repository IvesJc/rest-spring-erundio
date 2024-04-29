package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullExecption extends RuntimeException implements Serializable {

    public RequiredObjectIsNullExecption(String message) {
        super(message);
    }

    public RequiredObjectIsNullExecption() {
        super("It is not allowed to persist a null object");
    }
}
