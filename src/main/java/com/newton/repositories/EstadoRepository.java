package com.newton.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.newton.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	@Transactional(readOnly=true) //Como a operação não é de inserção deixar como read only torna a mesma mais rápida
	public List<Estado> findAllByOrderByNome();
}