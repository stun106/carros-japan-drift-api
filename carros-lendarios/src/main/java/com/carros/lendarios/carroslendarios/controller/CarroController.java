package com.carros.lendarios.carroslendarios.controller;

import com.carros.lendarios.carroslendarios.model.Carros;
import com.carros.lendarios.carroslendarios.service.imp.CarrosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carros")
@RequiredArgsConstructor
public class CarroController {

    @Autowired
    private CarrosService carrosService;

    @PostMapping("/criar")
    public ResponseEntity<Carros> criarCarros(@RequestBody Carros carros){
        if (carros != null){
            carrosService.criarCarrro(carros);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(carros);
    }
}
