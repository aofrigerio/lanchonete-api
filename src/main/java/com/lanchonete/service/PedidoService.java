package com.lanchonete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lanchonete.model.Ingrediente;
import com.lanchonete.model.Pedido;
import com.lanchonete.repository.IngredienteRepository;
import com.lanchonete.repository.LancheRepository;
import com.lanchonete.repository.PedidoRepository;

@Service
public class PedidoService {
	
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	@Autowired
	LancheRepository lancheRepository;
	
	public Pedido create(Pedido pedido) {
		
		//salva o pedido
		pedidoRepository.save(pedido);
		/*
		Lanche lanche = lancheRepository.findAllById(pedido.getPedidoItens())
		
		List<PedidoItem> pedidoItens = lancheService
		*/
		
		
		
		return pedido;
	}
	
	public List<Pedido> createPedidos(List<Pedido> pedidos){
		return pedidoRepository.saveAll(pedidos);
	}
	
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
}
