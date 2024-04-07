package com.carros.lendarios.carroslendarios.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record CarroRecord(UUID idCar, String nome, String descricao,
                          String fabricante, String foto, LocalDateTime dataFabricacao) {
}
