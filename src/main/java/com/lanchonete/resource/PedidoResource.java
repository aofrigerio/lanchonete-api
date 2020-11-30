package com.lanchonete.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;
import com.lanchonete.model.Lanche;
import com.lanchonete.model.Pedido;
import com.lanchonete.model.PedidoRequest;
import com.lanchonete.service.PedidoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("pedido")
@Api
public class PedidoResource {
	
	@Autowired
	PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> gerarPedido(@RequestBody List<PedidoRequest> pedidoRequest){	
		/*
		Pedido pedidonew = new Pedido();
				
		pedidonew.setId((long) 1);
		pedidonew.setQuantidadePedido(5);
		pedidonew.setValorTotalPedido(15);
		//System.out.println(pedidoRequest.getLanches());
		//pedidonew.setLanche(pedidoRequest.getLanches());
		*/
		Pedido pedido = pedidoService.gerarPedido(pedidoRequest);
			
		return ResponseEntity.ok(pedido);
	}

}
