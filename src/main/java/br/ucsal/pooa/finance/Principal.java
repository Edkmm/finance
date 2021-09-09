package br.ucsal.pooa.finance;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

import br.ucsal.pooa.finance.model.Lancamento;

public class Principal {

	public static void main(String[] args) {
		
		//M V C
		//
		
		new Lancamento(Lancamento.DESPESA, new BigDecimal("1_000"), "Escola");
		
	}

}
