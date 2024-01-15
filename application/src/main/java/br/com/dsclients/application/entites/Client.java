package br.com.dsclients.application.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private Double income;

    @Column(columnDefinition = "TIMESTAMP WITH OUT TIMEZONE")
    private Instant birthDate;

    private Integer children;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createadAt;

    @CreationTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
}
