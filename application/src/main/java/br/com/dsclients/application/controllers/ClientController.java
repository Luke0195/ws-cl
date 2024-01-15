package br.com.dsclients.application.controllers;

import br.com.dsclients.application.dtos.ClientDto;
import br.com.dsclients.application.services.impl.ClientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
    private final ClientServiceImpl clientServiceImpl;
    @Autowired
    public ClientController(ClientServiceImpl clientServiceImpl){
        this.clientServiceImpl = clientServiceImpl;
    }
    @PostMapping
    public ResponseEntity<ClientDto> createClient(@Valid @RequestBody ClientDto dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(clientServiceImpl.create(dto));
    }

}
