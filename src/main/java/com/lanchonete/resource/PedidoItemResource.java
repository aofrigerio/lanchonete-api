package com.lanchonete.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanchonete.model.PedidoItem;
import com.lanchonete.service.PedidoItemService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("pedidoItem")
@Api
public class PedidoItemResource {
	
	@Autowired
	PedidoItemService pedidoItemService;
	
	@PostMapping
	public ResponseEntity<PedidoItem> create(@RequestBody PedidoItem pedidoItem){	
		
		return ResponseEntity.ok(pedidoItemService.saveItemPedido(pedidoItem));
	}
	
	@PostMapping("/list")
	public ResponseEntity<List<PedidoItem>> createItens(@RequestBody List<PedidoItem> pedidoItens){	

		List<PedidoItem> newItemPedidos = pedidoItemService.saveItemPedidos(pedidoItens);
			
		return ResponseEntity.ok(newItemPedidos);
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoItem>> listAll(){
		return ResponseEntity.ok(pedidoItemService.getItemPedidoItems());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<PedidoItem> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoItemService.getItemPedidoItemById(id));
    }

    @PutMapping
    public ResponseEntity<PedidoItem> update(@RequestBody PedidoItem PedidoItem) {
        return ResponseEntity.ok(pedidoItemService.updateItemPedidoItem(PedidoItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id) {
        return ResponseEntity.ok(pedidoItemService.deleteItemPedidoItem(id));
    }

}
