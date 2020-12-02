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
@RequestMapping("PedidoItem")
@Api
public class PedidoItemResource {
	
	@Autowired
	PedidoItemService pedidoItemService;
	
	@PostMapping
	public ResponseEntity<PedidoItem> create(@RequestBody PedidoItem PedidoItem){	
			
		return ResponseEntity.ok(PedidoItem);
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoItem>> listAll(){
		return ResponseEntity.ok(pedidoItemService.getItemPedidoItems());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<PedidoItem> findOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoItemService.getItemPedidoItemById(id));
    }

    @PutMapping
    public ResponseEntity<PedidoItem> updateOrder(@RequestBody PedidoItem PedidoItem) {
        return ResponseEntity.ok(pedidoItemService.updateItemPedidoItem(PedidoItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(Long id) {
        return ResponseEntity.ok(pedidoItemService.deleteItemPedidoItem(id));
    }

}
