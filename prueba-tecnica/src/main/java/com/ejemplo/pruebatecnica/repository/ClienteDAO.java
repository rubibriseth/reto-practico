package com.ejemplo.pruebatecnica.repository;

import com.ejemplo.pruebatecnica.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

}
