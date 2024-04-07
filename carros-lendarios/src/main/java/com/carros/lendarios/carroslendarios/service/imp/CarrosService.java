package com.carros.lendarios.carroslendarios.service.imp;

import com.carros.lendarios.carroslendarios.model.Carros;
import com.carros.lendarios.carroslendarios.repository.CarrosRepository;
import com.carros.lendarios.carroslendarios.service.CarrosInterfaceImp;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrosService implements CarrosInterfaceImp {
    private final CarrosRepository carrosRepository;

    @Override //com.carros.lendarios.carroslendarios.service
    public void criarCarrro (Carros carros) {
        try {
            carrosRepository.save(carros);
        }catch (EntityExistsException e){
            throw new EntityExistsException("Esse carro ja existe na base de dados.");
        }
    }

    @Override //com.carros.lendarios.carroslendarios.service
    public List<Carros> buscarCarros (){
        try {
            return carrosRepository.findAll();
        }catch(RuntimeException e){
            throw new RuntimeException("Erro ao buscar dados da Api");
        }
    }
}
