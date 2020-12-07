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
	
	@Autowired
	DescontoService descontoService;
	
	
	public PedidoItem saveItemPedido(PedidoItem pedidoItem) {
		
		Pedido newPedido = calcularSalvarItem(pedidoItem);
		PedidoItem newPedidoItem = pedidoItemRepository.save(pedidoItem);
				
		//Aplica a regra de desconto
		descontoService.atualizarValorDesconto(newPedido);		
		
		return newPedidoItem;
	}
	
	public List<PedidoItem> saveItemPedidos(List<PedidoItem> pedidoItens){
		
		pedidoItens.stream().forEach(action -> 	{
			Pedido newPedido = calcularSalvarItem(action);		
			
			descontoService.atualizarValorDesconto(newPedido);
			
		} );
				
		return pedidoItemRepository.saveAll(pedidoItens);
	}
	
	public List<PedidoItem> pedirLanche(Long id){
		
		Pedido pedido = new Pedido();
		pedido.setValorTotalPedido(0);
		pedido.setValorTotalDesconto(0);	
		
		Lanche lanche = lancheRepository.findById(id).get();
		List<Ingrediente> ingredientes = lanche.getIngredientes();
		List<PedidoItem> pedidoItens = new ArrayList<PedidoItem>();
		
		Pedido newPedido = pedidoService.create(pedido);
		
		
		ingredientes.stream().forEach(item ->{
			PedidoItem pedidoItemStream = new PedidoItem();
			pedidoItemStream.setPedido(newPedido);
			pedidoItemStream.setIngrediente(item);
			pedidoItens.add(pedidoItemStream);
		});
		
		List<PedidoItem> newPedidoItens = saveItemPedidos(pedidoItens);
		
		//Aplica a regra de desconto aqui também
		descontoService.atualizarValorDesconto(newPedido);
						
		return newPedidoItens;
	}
	
	public List<PedidoItem> getItemPedidoItems() {
        return pedidoItemRepository.findAll();
    }

    public PedidoItem getItemPedidoItemById(Long id) {
        return pedidoItemRepository.findById(id).orElse(null);
    }
    
    public List<PedidoItem> getItemPedidoPorPedido(Long id) {
    	return pedidoItemRepository.listarPorItensPorPedido(id);
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
    
    public List<PedidoItem> listarTodos(){
    	return pedidoItemRepository.findAll();
    }
    
 	private Pedido calcularSalvarItem(PedidoItem pedidoItem) {
		
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
				
		return pedidoRepository.save(pedido);
		
	}
	
    
}
