package com.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanchonete.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
