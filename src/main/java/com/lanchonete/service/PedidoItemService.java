package com.lanchonete.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lanchonete.model.Ingrediente;
import com.lanchonete.model.Lanche;
import com.lanchonete.model.Pedido;
import com.lanchonete.model.PedidoItem;
import com.lanchonete.repository.IngredienteRepository;
import com.lanchonete.repository.LancheRepository;
import com.lanchonete.repository.PedidoItemRepository;
import com.lanchonete.repository.PedidoRepository;

@Service
public class PedidoItemService {
	
	
	@Autowired
	PedidoItemRepository pedidoItemRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	@Autowired
	LancheRepository lancheRepository;
	
	
	public PedidoItem saveItemPedido(PedidoItem pedidoItem) {
		
		calcularSalvarItem(pedidoItem);
		
		return pedidoItemRepository.save(pedidoItem);
	}
	
	public List<PedidoItem> saveItemPedidos(List<PedidoItem> pedidoItens){
		
		pedidoItens.stream().forEach(action -> 	calcularSalvarItem(action) );
				
		return pedidoItemRepository.saveAll(pedidoItens);
	}
	
	public List<PedidoItem> pedirLanche(Long id){
		
		Pedido pedido = new Pedido();
		pedido.setValorTotalPedido(0);	
		
		Lanche lanche = lancheRepository.findById(id).get();
		List<Ingrediente> ingredientes = lanche.getIngredientes();
		List<PedidoItem> pedidoItens = new ArrayList<PedidoItem>();
		
		Pedido newPedido = pedidoService.create(pedido);
		
		
		ingredientes.stream().forEach(item ->{
			PedidoItem pedidoItemStream = new PedidoItem();
			System.out.println(item.getNome());
			pedidoItemStream.setPedido(newPedido);
			pedidoItemStream.setIngrediente(item);
			pedidoItens.add(pedidoItemStream);
		});
				
		return saveItemPedidos(pedidoItens);
	}
	
	public List<PedidoItem> getItemPedidoItems() {
        return pedidoItemRepository.findAll();
    }

    public PedidoItem getItemPedidoItemById(Long id) {
        return pedidoItemRepository.findById(id).orElse(null);
    }

    public PedidoItem updateItemPedidoItem(PedidoItem PedidoItem) {
        if (pedidoItemRepository.findById(PedidoItem.getId()) != null) {
            return pedidoItemRepository.save(PedidoItem);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PedidoItem not found");
    }

    public String deleteItemPedidoItem(Long id) {
    	pedidoItemRepository.deleteById(id);
        return "PedidoItem removed : " + id;
    }
    
    

	private void calcularSalvarItem(PedidoItem pedidoItem) {
		
		double valorTotalPedido = 0;
		double valorTotalIngrediente = 0;
		
		Pedido pedido = pedidoRepository.findById(pedidoItem.getPedido().getId()).get();
		Ingrediente ingrediente = new Ingrediente();
 		
		if(pedidoItem.getIngrediente() != null) {
			ingrediente =  ingredienteRepository.findById(pedidoItem.getIngrediente().getId()).get();
		}
		
		//Soma os valores
		valorTotalIngrediente = ingrediente.getPreco();
		valorTotalPedido = pedido.getValorTotalPedido() + valorTotalIngrediente;
		
		//seta os vlores
		pedidoItem.setValorTotalIngredientes(valorTotalIngrediente);
		pedido.setValorTotalPedido(valorTotalPedido);
		
		pedidoRepository.save(pedido);
		
	}
	
    
}
