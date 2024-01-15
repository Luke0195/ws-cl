package br.com.dsclients.application.services.impl;

import br.com.dsclients.application.dtos.ClientDto;
import br.com.dsclients.application.entites.Client;
import br.com.dsclients.application.mappers.ClientMapper;
import br.com.dsclients.application.repositories.ClientRepository;
import br.com.dsclients.application.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public ClientDto create(ClientDto dto) {
        Optional<Client> entityAlreadyExists = clientRepository.findByCpf(dto.getCpf());
        if(entityAlreadyExists.isPresent()) throw new RuntimeException("This cpf is already taken!");
        Client client = ClientMapper.mapClientDtoEntity(dto);
        client = clientRepository.save(client);
        return ClientMapper.mapEntityToClientDto(client);
    }



}
