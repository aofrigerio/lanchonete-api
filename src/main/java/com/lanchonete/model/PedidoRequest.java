package com.lanchonete.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	
@AllArgsConstructor
public class PedidoRequest {
	
	private int quantidade;
	private Long lanche;
	private List<PedidoRequestAdicionais> adicionais; //id_quantidade, id_ingrediente 
	
}
