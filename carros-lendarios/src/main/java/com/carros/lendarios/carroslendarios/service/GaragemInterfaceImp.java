package com.carros.lendarios.carroslendarios.service;

import com.carros.lendarios.carroslendarios.model.Carros;
import com.carros.lendarios.carroslendarios.model.Garagem;

import java.util.List;
import java.util.UUID;

public interface GaragemInterfaceImp {
    void criarGaragem(Garagem garagem);

    void adicionarCarros(UUID id, UUID idCar);

    List<Garagem> buscarTodasGaragens ();

}
