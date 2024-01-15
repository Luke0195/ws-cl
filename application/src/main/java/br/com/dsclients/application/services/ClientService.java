package br.com.dsclients.application.services;

import br.com.dsclients.application.dtos.ClientDto;
import org.springframework.data.domain.Page;

public interface ClientService {
    ClientDto create(ClientDto dto);
    Page<ClientDto> findAllClients();
}
