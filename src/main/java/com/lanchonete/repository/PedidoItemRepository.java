package com.lanchonete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lanchonete.model.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{
	

	@Query("select i from PedidoItem i where i.pedido.id = :id_pedido")
	List<PedidoItem> listarPorItensPorPedido(Long id_pedido);
	
}
