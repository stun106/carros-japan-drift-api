package com.carros.lendarios.carroslendarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Carros {
    @Id
    @Column(name="id_car")
    @GeneratedValue(generator = "UUID")
    private UUID idCar;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String fabricante;
    private String foto;
    @Column(name="data_fabricacao")
    private LocalDateTime dataFabricacao = LocalDateTime.now();
}
