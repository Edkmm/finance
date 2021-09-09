package br.ucsal.pooa.finance.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import br.ucsal.pooa.finance.model.Lancamento;

public class Janela {
	
	private Scanner terminal = new Scanner(System.in);
	List<Lancamento> lista;
	
	public Janela() {
		ini();
	}
	
	public void ini() {
		String op;
		do {
			op = terminal.nextLine();
		} while (op.equals(op;)
	}
	

	public void listar() {
		// lista
		for (Lancamento lancamento : lista) {
			System.out.println(lancamento);
		}
	}

	public void cadastrar() {
		String tipo;
		do {
		System.out.print("Digite o Tipo 1- DESPESA ou 2 RECEITA [1 - DESPESA] :");
		tipo = terminal.nextLine();
		
		tipo = tipo.trim(); // tira os espaços do início e do fim ?!?!
		if (tipo.isEmpty() || tipo.equals("1")) {
			tipo = "DESPESA";
		} else if (tipo.equals("2")) {
			tipo = "RECEITA";
		} 
		} while ( !(tipo.equals("DESPESA") || tipo.equals("RECEITA")));
		
		System.out.print("Digite a Descrição["+tipo+"]:");
		String descricao = terminal.nextLine();
		if (descricao.isEmpty()) {
			descricao = tipo;
		}
		
		System.out.print("Digite a Valor:");
		String valor = terminal.nextLine();
		BigDecimal amount = new BigDecimal(valor);
		
		Lancamento lancamento = new Lancamento(tipo, amount, descricao);
		lista.add(null);
	}

}
