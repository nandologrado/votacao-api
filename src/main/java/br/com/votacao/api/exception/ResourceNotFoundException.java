package br.com.votacao.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2847738697992392276L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
