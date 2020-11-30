package com.lanchonete.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	
@AllArgsConstructor
public class PedidoRequestAdicionais {
	
	private int ingrediente;
	private int quantidade; 
	
}
