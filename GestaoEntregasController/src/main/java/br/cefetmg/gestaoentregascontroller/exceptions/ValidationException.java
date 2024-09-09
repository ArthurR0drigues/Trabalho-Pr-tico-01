package br.cefetmg.gestaoentregascontroller.exceptions;

public class ValidationException extends Exception {
    public ValidationException(String mensagem) {
        super(mensagem);
    }
}
