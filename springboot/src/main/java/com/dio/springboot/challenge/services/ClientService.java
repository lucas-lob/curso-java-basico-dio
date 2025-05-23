package com.dio.springboot.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.springboot.challenge.models.Client;
import com.dio.springboot.challenge.models.ClientRepository;

import com.dio.springboot.challenge.models.Address;
import com.dio.springboot.challenge.models.AddressRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public void newClient(Client client) {
        String clientCep = client.getAddress().getCep();

        String a = viaCepService.getAddress(clientCep);
        System.out.println(a);

        // Address clientAddress = addressRepository.findById(clientCep).orElseGet(() -> {
        //     Address newAddress = viaCepService.getAddress(clientCep);
        //     addressRepository.save(newAddress);
        //     return newAddress;
        // });

        // client.setAddress(clientAddress);
        clientRepository.save(client);
    }

}
