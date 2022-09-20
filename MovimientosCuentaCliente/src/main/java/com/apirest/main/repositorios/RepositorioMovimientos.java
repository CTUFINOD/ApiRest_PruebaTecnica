package com.apirest.main.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.main.entidades.Movimientos;

@Repository
public interface RepositorioMovimientos extends JpaRepository<Movimientos, Integer> {

}
