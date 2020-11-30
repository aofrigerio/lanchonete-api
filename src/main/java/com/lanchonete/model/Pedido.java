package com.lanchonete.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	private long id;
	private double valorTotalPedido;
	private int quantidadePedido;
	private List<Lanche> lanches = new ArrayList<Lanche>();
	private double valorAdicional;
	
	public void addLanche(Lanche lanche) {
		this.lanches.add(lanche);
	}

}
