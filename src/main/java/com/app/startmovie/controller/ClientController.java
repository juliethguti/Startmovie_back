/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.startmovie.controller;

import com.app.startmovie.dto.ReportClientDto;
import com.app.startmovie.dto.ResponseDto;
import com.app.startmovie.service.ClientService;
import com.app.startmovie.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("")
    public Iterable<Client> get() {
        return service.get();
    }

    @GetMapping("/report")
    public ReportClientDto getReport() {
        return service.getReport();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDto> create(@RequestBody Client request) {
        ResponseDto responseDto = service.create(request);
        ResponseEntity<ResponseDto> responseC = new ResponseEntity<>(responseDto,HttpStatus.CONFLICT);

        if(responseDto.status.booleanValue()==true){
            responseC = new ResponseEntity<>(responseDto,HttpStatus.CREATED);
        }
        return responseC;
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client update(@RequestBody Client request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
