package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExecption extends RuntimeException implements Serializable {

    public ResourceNotFoundExecption(String message) {
        super(message);
    }
}
