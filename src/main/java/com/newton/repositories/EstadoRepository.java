package com.newton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newton.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}