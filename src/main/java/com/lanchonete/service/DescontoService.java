package com.lanchonete.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanchonete.model.Pedido;
import com.lanchonete.model.PedidoItem;

@Service
public class DescontoService {

	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	PedidoItemService pedidoItemService;
	
	public void atualizarValorDesconto(Pedido pedido) {
		
		 long totalHamburguer = 0;
		 long totalQueijo = 0;
		 long totalAlface = 0;
		 long totalBacon = 0;
		 double valorHamburguer = 0;
		 double valorQueijo = 0;
		 double valorTotalDesconto = 0;
		 double valorTotalPedido = 0;
				 
		List<PedidoItem> listaPedidosBanco = pedidoItemService.getItemPedidoPorPedido(pedido.getId());				
	
		//Refaz a soma do pedido
		if(listaPedidosBanco.size() > 0) {
			valorTotalPedido = listaPedidosBanco
					.stream()
					.map(item -> item.getIngrediente().getPreco())
					.reduce( (a, b) -> a += b).get();
		}
	
		//Conta quantos itens existem
		//Deixei explícito para entender ficar didático
		totalAlface = listaPedidosBanco
			.stream()
			.filter(item -> item.getIngrediente().getNome().equalsIgnoreCase("Alface"))
			.count();
		
		totalBacon = listaPedidosBanco
				.stream()
				.filter(item -> item.getIngrediente().getNome().equalsIgnoreCase("bacon"))
				.count();
		
		totalHamburguer = listaPedidosBanco
				.stream()
				.filter(item -> item.getIngrediente().getNome().equalsIgnoreCase("hamburguer"))
				.count();
		
		totalQueijo = listaPedidosBanco
				.stream()
				.filter(item -> item.getIngrediente().getNome().equalsIgnoreCase("queijo"))
				.count();
		
		//Teste via console
		System.out.println("total totalAlface:" + totalAlface);
		System.out.println("total totalBacon:" + totalBacon);
		System.out.println("total totalHamburguer:" + totalHamburguer);
		System.out.println("total totalQueijo:" + totalQueijo);
	
		//Regra pra muitos hamburguers
		if(totalHamburguer >= 3) {
			
			//Recupera o pedido já da lista do pedido
			valorHamburguer = listaPedidosBanco
									.stream()
									.filter(item -> item.getIngrediente().getNome().equalsIgnoreCase("hamburguer"))
									.findFirst()
									.get()
									.getIngrediente().getPreco();
			
			if((totalHamburguer % 3) <= 0) {
				valorTotalDesconto += new BigDecimal(valorHamburguer).setScale(2,RoundingMode.HALF_UP).doubleValue();
			} else {
				
			}
		}
		
		//Regra para muitos queijos
		if(totalQueijo >= 3) {
			
			//Recupera o pedido já da lista do pedido
			valorQueijo = listaPedidosBanco
					.stream()
					.filter(item -> item.getIngrediente().getNome().equalsIgnoreCase("queijo"))
					.findFirst()
					.get()
					.getIngrediente().getPreco();
			
			if((totalQueijo % 3) <= 0) {
				valorTotalDesconto += new BigDecimal(valorQueijo).setScale(2,RoundingMode.HALF_UP).doubleValue();
			}
		}
		
		//Regra pra lanche light	
		if(totalBacon <= 0 && totalAlface > 0) {	 
			valorTotalDesconto += new BigDecimal(pedido.getValorTotalPedido() * 0.1).setScale(2,RoundingMode.HALF_UP).doubleValue();
		}
			
		//Atualiza somente no pedido, onde tem o valor total
		pedido.addDesconto(valorTotalDesconto);
		double valorAtualizado = (valorTotalPedido - pedido.getValorTotalDesconto());
		
		pedido.setValorTotalPedido(new BigDecimal(valorAtualizado).setScale(2,RoundingMode.HALF_UP).doubleValue());
				
		pedidoService.create(pedido);		
		
	}
}
