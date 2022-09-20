package com.apirest.main.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.main.entidades.Cuenta;

@Repository
public interface  RepositorioCuenta extends JpaRepository<Cuenta, Integer> {

}
