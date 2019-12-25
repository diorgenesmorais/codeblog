package com.example.codeblog.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dms.useful.exception.handler.ResourcesExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResourcesExceptionHandler {

}
