package com.carros.lendarios.carroslendarios.dto;

import com.carros.lendarios.carroslendarios.model.Carros;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GaragemDto {
    private UUID id;
    private String nome;
    private long quantCarros = 0;
    private List<Carros> carros = new ArrayList<>();
}
