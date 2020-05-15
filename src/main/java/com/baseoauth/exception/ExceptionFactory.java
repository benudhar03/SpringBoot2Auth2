package com.baseoauth.exception;

public interface ExceptionFactory<E extends Exception>
{
    E create(String message);
}