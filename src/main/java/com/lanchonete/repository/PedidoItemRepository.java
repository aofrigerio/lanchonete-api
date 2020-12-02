package com.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanchonete.model.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{

}
