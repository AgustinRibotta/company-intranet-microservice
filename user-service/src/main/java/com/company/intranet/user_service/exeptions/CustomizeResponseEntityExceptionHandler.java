package com.company.intranet.user_service.exeptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // Handles any generic exception not caught by other handlers
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request)
            throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handles exceptions when a user with a given ID is not found
    @ExceptionHandler(IdNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoudExeption(Exception ex, WebRequest request)
            throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Handles errors when a method argument type is invalid (e.g., passing String instead of Integer)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<ErrorDetails> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // Handles authorization errors when a user lacks sufficient permissions
    @ExceptionHandler({org.springframework.security.authorization.AuthorizationDeniedException.class})
    public ResponseEntity<ErrorDetails> handleAuthorizationDenied(AuthorizationDeniedException ex,
                                                                  WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorDetails);
    }

    // Overrides default validation error handling for @Valid annotated method arguments
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @SuppressWarnings("null") MethodArgumentNotValidException ex,
            @SuppressWarnings("null") HttpHeaders headers, @SuppressWarnings("null") HttpStatusCode status,
            @SuppressWarnings("null") WebRequest request) {
        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (msg1, msg2) -> msg1));
        ;

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                errors.toString(),
                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // Handles database integrity violations (e.g., duplicate keys, constraint violations)
    @SuppressWarnings("null")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDetails> handleDataIntegrityViolation(
            DataIntegrityViolationException ex, WebRequest request) {

        String rootMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();
        String userFriendlyMessage = "Data integrity violation";

        if (rootMessage != null) {

            Pattern pattern = Pattern.compile("\\((\\w+)\\s?NULLS FIRST\\)");
            Matcher matcher = pattern.matcher(rootMessage);

            if (matcher.find()) {
                String column = matcher.group(1);
                userFriendlyMessage = column + " already exists";
            }
        }

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                userFriendlyMessage,
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }


    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<ErrorDetails> handleExternalService(
            ExternalServiceException ex, WebRequest request) {

        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(error);
    }
}
