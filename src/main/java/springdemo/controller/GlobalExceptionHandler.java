package springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import springdemo.entity.StudentExceptionResponse;
import springdemo.exception.StudentNullException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentExceptionResponse> studentExceptionHandler(StudentNullException exception){
        StudentExceptionResponse ser = new StudentExceptionResponse();
        ser.setMessage(exception.getMessage());
        ser.setStatus(HttpStatus.NOT_FOUND.value());
        ser.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(ser,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentExceptionResponse> studentExceptionHandler(MethodArgumentTypeMismatchException exception){
        StudentExceptionResponse ser = new StudentExceptionResponse();
        ser.setMessage("The input must be Integer!");
        ser.setStatus(HttpStatus.BAD_REQUEST.value());
        ser.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(ser,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<StudentExceptionResponse> studentExceptionHandler(Exception exception){
        StudentExceptionResponse ser = new StudentExceptionResponse();
        ser.setMessage(exception.getMessage());
        ser.setStatus(HttpStatus.BAD_REQUEST.value());
        ser.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(ser,HttpStatus.BAD_REQUEST);
    }

}
