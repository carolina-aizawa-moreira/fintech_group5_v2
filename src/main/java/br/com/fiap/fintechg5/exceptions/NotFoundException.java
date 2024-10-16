package br.com.fiap.fintechg5.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends Exception {

    public NotFoundException (String message) {
        super(message);
    }
}
