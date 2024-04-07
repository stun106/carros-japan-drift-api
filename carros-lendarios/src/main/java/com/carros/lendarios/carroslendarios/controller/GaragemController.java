package com.carros.lendarios.carroslendarios.controller;

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

    private static GaragemService garagemService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarGaragem (@RequestBody Garagem garagem1) {
        if (garagem1 != null) {
            garagemService.criarGaragem(garagem1);
            return ResponseEntity.status(HttpStatus.CREATED).body("Criado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao enviar dados para API.");
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<Garagem>> buscarGaragens (){
        List<Garagem> response = garagemService.buscarTodasGaragens();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}/adicionar-carros")
    public  ResponseEntity<HttpStatus> adicionarCarros (@PathVariable UUID id, @RequestBody Map<String,String> idCar) {
        String idCarro = idCar.get("idCar");
        garagemService.adicionarCarros(id,UUID.fromString(idCarro));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
