package br.com.dsclients.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientDto implements Serializable {

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    @JsonProperty("brith_date")
    private Instant brithDate;
    private Integer children;

    @JsonProperty("created_at")
    private Instant createdAt;
    @JsonProperty("updated_at")
    private Instant updatedAt;
}
