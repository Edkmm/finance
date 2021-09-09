package br.ucsal.pooa.finance.model;

	import java.math.BigDecimal;

	public class Lancamento {
		
		public static final String DESPESA = "DESPESA";
		public static final String RECEITA = "RECEITA";
		
		private String tipo;
		private BigDecimal valor;
		private String descricao;
		
		public Lancamento(String tipo, BigDecimal valor, String descricao) {
			super();
			this.tipo = tipo;
			this.valor = valor;
			this.descricao = descricao;
		}
		

	}

