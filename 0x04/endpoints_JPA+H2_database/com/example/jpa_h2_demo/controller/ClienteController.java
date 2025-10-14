package com.example.jpa_h2_demo.controller;

import com.example.jpa_h2_demo.model.Cliente;
import com.example.jpa_h2_demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        return new ResponseEntity<>(clienteRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Optional clienteOptional = clienteRepository.findById(idClient);

        if (clienteOptional.isPresent()) {
            return new ResponseEntity<>(clienteRepository.findById(idClient).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        clienteRepository.deleteById(idClient);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            cliente.setId(id);
            clienteRepository.save(cliente);
        }
    }
}
