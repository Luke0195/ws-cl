package br.com.dsclients.application.mappers;

import br.com.dsclients.application.dtos.ClientDto;
import br.com.dsclients.application.entites.Client;

public final class ClientMapper {
    private ClientMapper() {
    }

    public static Client mapClientDtoEntity(ClientDto clientDto) {
        return Client.builder()
            .name(clientDto.getName())
            .cpf(clientDto.getCpf())
            .income(clientDto.getIncome())
            .birthDate(clientDto.getBrithDate())
            .children(clientDto.getChildren())
            .createadAt(clientDto.getCreatedAt())
            .updatedAt(clientDto.getUpdatedAt())
            .build();
    }

    public static ClientDto mapEntityToClientDto(Client client) {
        return ClientDto.builder()
            .id(client.getId())
            .name(client.getName())
            .cpf(client.getCpf())
            .income(client.getIncome())
            .brithDate(client.getBirthDate())
            .children(client.getChildren())
            .createdAt(client.getCreateadAt())
            .updatedAt(client.getUpdatedAt())
            .build();
    }
}
