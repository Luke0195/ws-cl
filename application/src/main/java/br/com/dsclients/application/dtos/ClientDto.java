package br.com.dsclients.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientDto implements Serializable {

    private Long id;
    @NotBlank(message = "The field name must be required")
    private String name;
    @NotBlank(message= "The field message must be required")
    private String cpf;
    @NotBlank(message="The field income must be required")
    private Double income;
    @JsonProperty("brith_date")
    @NotBlank(message= "The field birth_date must be required")
    private Instant brithDate;
    @Size(min = 0, max = 99, message = "The field children cannot be null or string")
    private Integer children;

    @JsonProperty("created_at")
    private Instant createdAt;
    @JsonProperty("updated_at")
    private Instant updatedAt;
}
