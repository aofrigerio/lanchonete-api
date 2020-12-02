package com.lanchonete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lanchonete.model.Pedido;
import com.lanchonete.repository.IngredienteRepository;
import com.lanchonete.repository.PedidoRepository;

@Service
public class PedidoService {
	
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido updatePedido(Pedido Pedido) {
        if (pedidoRepository.findById(Pedido.getId()) != null) {
            return pedidoRepository.save(Pedido);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido not found");
    }

    public String deletePedido(Long id) {
    	pedidoRepository.deleteById(id);
        return "Pedido removed : " + id;
    }
    
	/*
	//Serviço responsável por montar o pedido
	public Pedido create(Pedido pedido) {
		
		double preco = 0;
		double valorAdicional = 0;
		
		//pedido.setId(Long.parseLong(null, 1));
		pedido.setId(1);		
		

		//Regra de desconto - Strategy
		PedidoRegraDesconto pedidoDesconto = new PedidoRegraDesconto();
		
		for(PedidoItens newPedidoRequest : pedidoRequest) {
			
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
		
			
		}
		
		//Processa o desconto
		pedidoDesconto.setPedido(pedido);
		pedidoDesconto.aplicarDesconto();
		
		return pedidoDesconto.getPedido();
	}
*/
	
	public Pedido create(Pedido pedido) {
		
		return pedido;
	}
}
