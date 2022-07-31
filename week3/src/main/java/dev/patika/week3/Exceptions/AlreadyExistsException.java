package dev.patika.week3.Exceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message) {super(message);}
}