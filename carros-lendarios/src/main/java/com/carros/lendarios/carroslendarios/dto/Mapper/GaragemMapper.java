package com.carros.lendarios.carroslendarios.dto.Mapper;

import com.carros.lendarios.carroslendarios.dto.GaragemDto;
import com.carros.lendarios.carroslendarios.model.Garagem;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class GaragemMapper {
    public static Garagem toGaragem (GaragemDto garagemDto){
        return new ModelMapper().map(garagemDto, Garagem.class);
    }
    public static GaragemDto toDto (Garagem garagem) {
        return new ModelMapper().map(garagem,GaragemDto.class);
    }
    public static List<GaragemDto> toListGaragem (List<Garagem> listaDeGaragem) {
        return listaDeGaragem.stream().map(GaragemMapper::toDto).collect(Collectors.toList());
    }
}
