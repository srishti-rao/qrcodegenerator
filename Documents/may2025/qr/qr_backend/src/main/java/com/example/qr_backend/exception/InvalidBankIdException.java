package com.example.qr_backend.exception;

public class InvalidBankIdException extends RuntimeException {
    public InvalidBankIdException(String message) {
        super(message);
    }
}
