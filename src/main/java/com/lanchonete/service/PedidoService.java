package com.lanchonete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanchonete.model.Ingrediente;
import com.lanchonete.model.Lanche;
import com.lanchonete.model.Pedido;
import com.lanchonete.model.PedidoRequest;
import com.lanchonete.model.PedidoRequestAdicionais;
import com.lanchonete.repository.IngredienteRepository;
import com.lanchonete.repository.LancheRepository;
import com.lanchonete.util.PedidoRegraDesconto;

@Service
public class PedidoService {
	
	
	@Autowired
	LancheRepository lancheRepository;
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	//Serviço responsável por montar o pedido
	public Pedido gerarPedido(List<PedidoRequest> pedidoRequest) {
		
		Pedido pedido = new Pedido();
		double preco = 0;
		double valorAdicional = 0;
		
		//pedido.setId(Long.parseLong(null, 1));
		pedido.setId(1);		
		

		//Regra de desconto
		PedidoRegraDesconto pedidoDesconto = new PedidoRegraDesconto();
		
		for(PedidoRequest newPedidoRequest : pedidoRequest) {
			
			//Coloca a quantidade requisitada no pedido pedido 
			pedido.setQuantidadePedido(newPedidoRequest.getQuantidade());
			
			//encontra o lanche e adiciona no pedido
			Lanche lanche = lancheRepository.findById(newPedidoRequest.getLanche()).get();
			pedido.addLanche(lanche);
			
			//preenche o preço dos ingredientes do lanche
			for(Ingrediente ingrediente : lanche.getIngredientes()) {
				preco = preco + ingrediente.getPreco();
			}
			
			//Insere o preco adicionais das coisas
			for(PedidoRequestAdicionais req : newPedidoRequest.getAdicionais()) {
				Ingrediente ingrediente = ingredienteRepository.findById((long) req.getIngrediente()).get();
				
				if(ingrediente != null) {
					pedido.addAdicional(ingrediente);
				}
				
				preco = preco + (ingrediente.getPreco() * req.getQuantidade());
				valorAdicional = valorAdicional + (ingrediente.getPreco() * req.getQuantidade());
			}
			
			pedido.setValorTotalPedido(preco * newPedidoRequest.getQuantidade());		
			pedido.setValorAdicional(valorAdicional * newPedidoRequest.getQuantidade());
			
			//Processa o desconto
			pedidoDesconto.setPedido(pedido);
			pedidoDesconto.aplicarDesconto();
			
		}
		
		return pedidoDesconto.getPedido();
	}

}
