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

import com.lanchonete.model.Lanche;
import com.lanchonete.model.Pedido;
import com.lanchonete.model.PedidoItem;
import com.lanchonete.service.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("pedido")
@Api
public class PedidoResource {
	
	@Autowired
	PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> create(@RequestBody Pedido pedido){	

		Pedido newPedido = pedidoService.create(pedido);
			
		return ResponseEntity.ok(newPedido);
	}
	
	@PostMapping("/list")
	public ResponseEntity<List<Pedido>> create(@RequestBody List<Pedido> pedidos){	

		List<Pedido> newPedido = pedidoService.createPedidos(pedidos);
			
		return ResponseEntity.ok(newPedido);
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> listAll(){
		return ResponseEntity.ok(pedidoService.getPedidos());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.getPedidoById(id));
    }

    @PutMapping
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.updatePedido(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(Long id) {
        return ResponseEntity.ok(pedidoService.deletePedido(id));
    }
    

}
