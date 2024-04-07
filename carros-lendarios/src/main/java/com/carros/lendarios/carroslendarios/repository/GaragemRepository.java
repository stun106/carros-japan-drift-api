package com.carros.lendarios.carroslendarios.repository;

import com.carros.lendarios.carroslendarios.model.Carros;
import com.carros.lendarios.carroslendarios.model.Garagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GaragemRepository extends JpaRepository<Garagem, UUID> {
    Optional<Garagem> findById(UUID id);

}