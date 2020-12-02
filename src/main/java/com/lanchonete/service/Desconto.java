package com.lanchonete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanchonete.model.Pedido;

@Service
public class Desconto {
	
	@Autowired
	IngredienteService ingredienteService;
	
	/*
	public Pedido processaDesconto(Pedido pedido) {
		
		//verifica quantos hamburguer tem
		double totalHamburguer = pedido
				.getPedidoItens()
				.stream()
				.filter(item -> item.getIngrediente().getNome() == "Hamburguer")
				.reduce(0, (subtotal, element) -> subtotal + element.getIngrediente().getPreco());
		
		 List<OrderItem> queijoItemList = orderItems
	                .stream()
	                .filter(sandwichItem -> sandwichItem.getIngredient()
	                        .getIngredientType().name()
	                        .equals(IngredientType.QUEIJO.name()))
	                .collect(Collectors.toList());
		 
		return pedido;
	}
	*/
}
