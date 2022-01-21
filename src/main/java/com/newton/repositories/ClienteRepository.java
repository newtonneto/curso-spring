package com.newton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.newton.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Transactional(readOnly=true) //Como a operação não é de inserção deixar como read only torna a mesma mais rápida
	Cliente findByEmail(String email);
}