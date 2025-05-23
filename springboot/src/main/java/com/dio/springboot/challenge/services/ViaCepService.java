package com.dio.springboot.challenge.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dio.springboot.challenge.models.Address;

@FeignClient(name="viacep", url="https://viacep.com.br/ws")
public interface  ViaCepService {

    @GetMapping("/{cep}/json")
    String getAddress(@PathVariable("cep") String cep);
    
}
