package com.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lanchonete.model.Lanche;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Long> {

}
