package com.carros.lendarios.carroslendarios.controller;

import com.carros.lendarios.carroslendarios.dto.GaragemDto;
import com.carros.lendarios.carroslendarios.dto.Mapper.GaragemMapper;
import com.carros.lendarios.carroslendarios.model.Carros;
import com.carros.lendarios.carroslendarios.model.Garagem;
import com.carros.lendarios.carroslendarios.service.imp.GaragemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/garagem")
public class GaragemController {
    @Autowired
    private GaragemService garagemService;

    @PostMapping("/criar")
    public ResponseEntity<GaragemDto> criarGaragem (@RequestBody GaragemDto garagemDto) {
        Garagem garagem = garagemService.criarGaragem(GaragemMapper.toGaragem(garagemDto));
            return ResponseEntity.status(HttpStatus.CREATED).body(GaragemMapper.toDto(garagem));
    }
    @GetMapping("/")
    public ResponseEntity<List<GaragemDto>> buscarGaragens (){
        List<Garagem> response = garagemService.buscarTodasGaragens();
        return ResponseEntity.status(HttpStatus.CREATED).body(GaragemMapper.toListGaragem(response));
    }

    @PatchMapping("/{id}/adicionar-carros")
    public  ResponseEntity<HttpStatus> adicionarCarros (@PathVariable UUID id, @RequestBody Map<String,String> idCar) {
        String idCarro = idCar.get("idCar");
        garagemService.adicionarCarros(id,UUID.fromString(idCarro));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
