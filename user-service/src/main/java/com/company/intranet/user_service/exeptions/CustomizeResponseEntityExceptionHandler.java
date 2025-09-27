package com.company.intranet.user_service.exeptions;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

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

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(Exception.class)
        public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request)
                        throws Exception {
                ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
                                request.getDescription(false));

                return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(IdNotFoundException.class)
        public final ResponseEntity<ErrorDetails> handleUserNotFoudExeption(Exception ex, WebRequest request)
                        throws Exception {
                ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
                                request.getDescription(false));

                return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(@SuppressWarnings("null") MethodArgumentNotValidException ex,
                        @SuppressWarnings("null") HttpHeaders headers, @SuppressWarnings("null") HttpStatusCode status, @SuppressWarnings("null") WebRequest request) {
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

        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public final ResponseEntity<ErrorDetails> handleMethodArgumentTypeMismatch(
                        MethodArgumentTypeMismatchException ex, WebRequest request) {

                ErrorDetails errorDetails = new ErrorDetails(
                                LocalDateTime.now(),
                                ex.getMessage(),
                                request.getDescription(false));

                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<ErrorDetails> handleDataIntegrityViolation(
                        DataIntegrityViolationException ex, WebRequest request) {

                @SuppressWarnings("null")
                String message = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();
                String userFriendlyMessage;

                if (message.contains("USER_ENTITY(EMAIL")) {
                        userFriendlyMessage = "Email already exists";
                } else {
                        userFriendlyMessage = "Data integrity violation";
                }

                ErrorDetails errorDetails = new ErrorDetails(
                                LocalDateTime.now(),
                                userFriendlyMessage,
                                request.getDescription(false));

                return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
        }

        @ExceptionHandler({ org.springframework.security.authorization.AuthorizationDeniedException.class })
        public ResponseEntity<ErrorDetails> handleAuthorizationDenied(AuthorizationDeniedException ex,
                                                                WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorDetails);
        }
}
