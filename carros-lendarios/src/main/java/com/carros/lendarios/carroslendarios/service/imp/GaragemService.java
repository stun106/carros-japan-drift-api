package com.carros.lendarios.carroslendarios.service.imp;

import com.carros.lendarios.carroslendarios.model.Carros;
import com.carros.lendarios.carroslendarios.model.Garagem;
import com.carros.lendarios.carroslendarios.repository.CarrosRepository;
import com.carros.lendarios.carroslendarios.repository.GaragemRepository;
import com.carros.lendarios.carroslendarios.service.GaragemInterfaceImp;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GaragemService implements GaragemInterfaceImp {

    private final GaragemRepository garagemRepository;
    private final CarrosRepository carrosRepository;
    @Override //com.carros.lendarios.carroslendarios.service
    public void criarGaragem ( Garagem garagem){
        try {
            garagemRepository.save(garagem);
            }catch (RuntimeException e){
            throw new RuntimeException("Erro ao enviar dados para API.",e);
        }
    }

    @Override
    public void adicionarCarros(UUID id, UUID idCar) {
        try{
            Garagem essaGaragem = garagemRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Garagem não existe."));
            Carros carros = carrosRepository.findById(idCar).orElseThrow(() ->
                    new RuntimeException("Carro não existe."));
            essaGaragem.getCarros().add(carros);
            long quant = essaGaragem.getQuantCarros() + 1;
            essaGaragem.setQuantCarros(quant);
            garagemRepository.save(essaGaragem);
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao persistir dados.");
        }

    }

    @Override //com.carros.lendarios.carroslendarios.service
    public List<Garagem> buscarTodasGaragens (){
        try {
           return garagemRepository.findAll();
        }catch (EntityExistsException e){
            throw  new EntityExistsException("Erro ao buscar dados da API.",e);
        }
    }
}
