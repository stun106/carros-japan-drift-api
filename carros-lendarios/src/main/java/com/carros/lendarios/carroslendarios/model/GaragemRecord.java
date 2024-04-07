package com.carros.lendarios.carroslendarios.model;

import java.util.List;
import java.util.UUID;

public record GaragemRecord(UUID id, String nome, Integer quantCarros, List<Carros> carros) {
}
