package com.carros.lendarios.carroslendarios.repository;

import com.carros.lendarios.carroslendarios.model.Carros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarrosRepository extends JpaRepository<Carros, UUID> {
}