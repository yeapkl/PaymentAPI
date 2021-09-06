package com.yeapkl.handler;

import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHanlder extends ResponseEntityExceptionHandler {

        @Override
        public ResponseEntity<Object> handleMissingServletRequestParameter(final MissingServletRequestParameterException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
            logger.info(ex.getClass().getName());
            //
            final String error = ex.getParameterName() + " parameter is missing";
            final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
            return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
        }

        @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
        public ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex, final WebRequest request) {
            logger.info(ex.getClass().getName());
            //
            final String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

            final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
            return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
        }

        // 404

        @Override
        public ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
            logger.info(ex.getClass().getName());
            //
            final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

            final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
            return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
        }

        @ExceptionHandler({PaymentDetailsNotFoundException.class})
        public ResponseEntity<Object> paymentDetailsNotFoundException(final PaymentDetailsNotFoundException ex) {
            logger.info(ex.getClass().getName());

            final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), ex.getLocalizedMessage());
            return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
        }

    }
