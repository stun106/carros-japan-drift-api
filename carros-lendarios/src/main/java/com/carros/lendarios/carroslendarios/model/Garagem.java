package com.carros.lendarios.carroslendarios.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Garagem {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "quant_carros")
    private long quantCarros = 0;
    @OneToMany
    @JoinColumn(name = "garagem_id")
    private List<Carros> carros = new ArrayList<>();
}
