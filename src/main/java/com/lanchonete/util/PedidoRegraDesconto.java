package com.lanchonete.util;

import java.util.List;

import com.lanchonete.model.Ingrediente;
import com.lanchonete.model.Lanche;
import com.lanchonete.model.Pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRegraDesconto {

	private Pedido pedido;
	private double valorDesconto;
	private double valorPedido;
	private double valorHamburguer;
	private double valorQueijo;
	private int quantidadeBacon;
	private int quantidadeHamburguer;
	private int quantidadeAlface;
	private int quantidadeQueijo;
	List<Ingrediente> ingredientes;

	public void aplicarDesconto() {

		List<Lanche> lanches = pedido.getLanches();
		List<Ingrediente> adicionais = pedido.getAdicionais();
		valorPedido = pedido.getValorTotalPedido();

		// Percorre as quantidades dos ingredientes do lanche
		lanches.forEach(item -> {
			this.ingredientes = item.getIngredientes();
			ingredientes.forEach(ingrediente -> {
				if (ingrediente.getNome().equalsIgnoreCase("bacon")) {
					quantidadeBacon++;
				}
				if (ingrediente.getNome().equalsIgnoreCase("alface")) {
					quantidadeAlface++;
				}

				if (ingrediente.getNome().equalsIgnoreCase("Hambúrguer")) {
					
					quantidadeHamburguer++;
					
					System.out.println();
					
					if(quantidadeHamburguer % 3 <= 0) {
						valorDesconto = valorDesconto - ingrediente.getPreco();
					}
					
				}

				if (ingrediente.getNome().equalsIgnoreCase("queijo")) {
					quantidadeQueijo++;
					
					if(valorQueijo % 3 <= 0 ) {
						valorDesconto = valorDesconto - ingrediente.getPreco();
					}
				}

			});
		}
		
		
		//percorre a quantidade dos adicionais
		);
		adicionais.forEach(item -> {
			if (item.getNome().equalsIgnoreCase("alface")) {
				quantidadeAlface++;
			}

			if (item.getNome().equalsIgnoreCase("queijo")) {
				quantidadeQueijo++;
			}

			if (item.getNome().equalsIgnoreCase("Hambúrguer")) {
				quantidadeHamburguer++;
			}

			if (item.getNome().equalsIgnoreCase("bacon")) {
				quantidadeBacon++;
			}
		});

		
		System.out.println("Valor do pedido: " + valorPedido);
		System.out.println("vALOR DO HAMBURGUER " + valorHamburguer);
		
		//se for light, subtrai 10%
		if(quantidadeAlface > 0 && quantidadeBacon <= 0) {
			valorDesconto = valorPedido * (0.1);
			this.pedido.setValorDesconto(valorDesconto);
			this.pedido.setValorTotalPedido(valorPedido - valorDesconto);
		}	
		/*
		//se tiver muitos hamburguers
		if(quantidadeHamburguer > 3) {
			this.pedido.setValorTotalPedido(valorPedido - ((quantidadeHamburguer / 3) * ));
		}
		*/
		//se tiver muitos queijos
		
		// Aplica o desconto
				System.out.println(valorDesconto);
				System.out.println(quantidadeAlface);
				System.out.println(quantidadeBacon);
				System.out.println(quantidadeQueijo);
				System.out.println(quantidadeHamburguer);

	}

}
