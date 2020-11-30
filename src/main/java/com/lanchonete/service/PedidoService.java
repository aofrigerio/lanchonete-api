package com.lanchonete.service;

import java.time.LocalDateTime;
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

@Service
public class PedidoService {
	
	
	@Autowired
	LancheRepository lancheRepository;
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	public Pedido gerarPedido(List<PedidoRequest> pedidoRequest) {
		
		Pedido pedido = new Pedido();
		double preco = 0;
		double valorAdicional = 0;
		
		//pedido.setId(Long.parseLong(null, 1));
		pedido.setId(1);		
		
		for(PedidoRequest newPedidoRequest : pedidoRequest) {
			
			pedido.setQuantidadePedido(newPedidoRequest.getQuantidade());			
			Lanche lanche = lancheRepository.findById(newPedidoRequest.getLanche()).get();
			pedido.addLanche(lanche);
			
			for(Ingrediente ingrediente : lanche.getIngredientes()) {
				preco = preco + ingrediente.getPreco();
			}
			
			for(PedidoRequestAdicionais req : newPedidoRequest.getAdicionais()) {
				Ingrediente ingrediente = ingredienteRepository.findById((long) req.getIngrediente()).get();
				preco = preco + (ingrediente.getPreco() * req.getQuantidade());
				valorAdicional = valorAdicional + (ingrediente.getPreco() * req.getQuantidade());
			}
			
			pedido.setValorTotalPedido(preco * newPedidoRequest.getQuantidade());		
			pedido.setValorAdicional(valorAdicional * newPedidoRequest.getQuantidade());
			
		}
		
		return pedido;
	}

}
