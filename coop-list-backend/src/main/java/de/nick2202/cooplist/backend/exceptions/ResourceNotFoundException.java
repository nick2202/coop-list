package de.nick2202.cooplist.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource not found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Message message) {
        super(String.valueOf(message));
    }


    public enum Message {
        ITEM_LIST_NOT_FOUND,
        LIST_ITEM_NOT_FOUND,
        ITEM_NOT_FOUND,
        USER_NOT_FOUND
    }

}
