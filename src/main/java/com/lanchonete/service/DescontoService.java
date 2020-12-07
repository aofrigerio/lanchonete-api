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
	
	@Autowired
	IngredienteService ingredienteService;
	
	public void atualizarValorDesconto(Pedido pedido) {
		
		 long totalHamburguer = 0;
		 long totalQueijo = 0;
		 long totalAlface = 0;
		 long totalBacon = 0;
		 double valorTotalDesconto = 0; 
		 double valorTotalPedido = 0;
				
		List<PedidoItem> listaPedidosBanco = pedidoItemService.getItemPedidoPorPedido(pedido.getId());
		//List<PedidoItem> listaPedidosBanco = pedidoItemService.listarTodos();
		Pedido pedidoBanco = pedidoService.getPedidoById(pedido.getId());
				
		//soma os valores dos itens novamente
		for(PedidoItem onePedidoItem : listaPedidosBanco) {
			System.out.println(onePedidoItem.getIngrediente().getPreco());
			valorTotalPedido = valorTotalPedido + onePedidoItem.getIngrediente().getPreco();
		}
		
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
		
		System.out.println("total totalAlface:" + totalAlface);
		System.out.println("total totalBacon:" + totalBacon);
		System.out.println("total totalHamburguer:" + totalHamburguer);
		System.out.println("total totalQueijo:" + totalQueijo);
	
		//Regra pra muitos hamburguers
		if(totalHamburguer >= 3) {
			if((totalHamburguer % 3) <= 0) {
				valorTotalDesconto +=  new BigDecimal((totalHamburguer / 3) * 3).setScale(2,RoundingMode.HALF_UP).doubleValue();
			}
		}
		
		//Regra para muitos queijos
		if(totalQueijo >= 3) {
			if((totalQueijo % 3) <= 0) {
				valorTotalDesconto +=  new BigDecimal((totalQueijo / 3) * 2).setScale(2,RoundingMode.HALF_UP).doubleValue();
			}
		}
		
		//Regra pra lanche light	
		if(totalBacon <= 0 && totalAlface > 0) {	 
			valorTotalDesconto = new BigDecimal(valorTotalPedido * 0.1).setScale(2,RoundingMode.HALF_UP).doubleValue();
		}
			
		//Atualiza somente no pedido, onde tem o valor total
		pedidoBanco.setValorTotalDesconto(valorTotalDesconto);
		pedidoBanco.setValorTotalPedido(new BigDecimal(valorTotalPedido - valorTotalDesconto).setScale(2,RoundingMode.HALF_UP).doubleValue());
		
		System.out.println("Valor Desconto:" + valorTotalDesconto);
		System.out.println("Valor Total Pedido:" + (valorTotalPedido - valorTotalDesconto));
		
		pedidoService.create(pedidoBanco);		
		
	}
}
