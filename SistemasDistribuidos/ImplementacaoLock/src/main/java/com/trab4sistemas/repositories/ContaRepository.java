package com.trab4sistemas.repositories;

import com.trab4sistemas.entitys.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}