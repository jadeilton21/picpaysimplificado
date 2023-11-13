package com.picpaysimplificado.picpaysimplificado.controller;


import com.picpaysimplificado.picpaysimplificado.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {


        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity threatDuplicationEntry(DataIntegrityViolationException exception){

            ExceptionDTO exceptionDTO = new ExceptionDTO("Usúario já exite.","400");
        return ResponseEntity.badRequest().body(exceptionDTO);

    }



    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException exception){
            return ResponseEntity.notFound().build();
    }










}
