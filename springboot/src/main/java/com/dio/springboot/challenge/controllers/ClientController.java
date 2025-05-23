package com.dio.springboot.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.springboot.challenge.models.Client;
import com.dio.springboot.challenge.services.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @GetMapping
    public ResponseEntity<Iterable<Client>> getAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    public ResponseEntity<Client> post(@RequestBody Client client){
        clientService.newClient(client);
        return ResponseEntity.ok(client);
    }
}
