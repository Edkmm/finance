package br.ucsal.pooa.finance.persistencia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.pooa.finance.model.Lancamento;

public class LancamentoDAO {

	//private List<Lancamento> lista = new ArrayList<>();

	private Connection conexao;
	
	public LancamentoDAO() {
		//String url = "jdbc:hsqldb:mem:mymemdb";
		String url = "jdbc:hsqldb:file:./banco/myfile.db";
		String usuario = "SA";
		String senha = "";

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver" );
			conexao = DriverManager.getConnection(url, usuario, senha);
			Statement createTable = conexao.createStatement();
			createTable.execute("CREATE TABLE LANCAMENTOS (TIPO CHAR(1), DESCRICAO VARCHAR(500), VALOR DOUBLE)");
			createTable.close();
			Statement insert = conexao.createStatement(); 
			insert.execute("INSERT INTO LANCAMENTOS (TIPO, DESCRICAO, VALOR) VALUES('D', 'DESPESA', 10.0 ) ");
			insert.execute("INSERT INTO LANCAMENTOS (TIPO, DESCRICAO, VALOR) VALUES('R', 'RECEITA', 100.0 ) ");
			insert.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Lancamento> listar() {
		// TODO ver boas prAticas
		List<Lancamento> lista = new ArrayList<>();
		try {
			Statement select = conexao.createStatement();
			ResultSet resultSet = select.executeQuery("SELECT * FROM LANCAMENTOS");
			
			while (resultSet.next()) {
				String descricao = resultSet.getString("DESCRICAO");
				String c = resultSet.getString("TIPO");
				String tipo = "RECEITA";
				if (c.equals("D")) {
					tipo = "DESPESA";
				}
				double valor = resultSet.getDouble("VALOR");
				BigDecimal bigDecimal = new BigDecimal(valor);
				Lancamento lancamento = new Lancamento(tipo, bigDecimal, descricao);
				lista.add(lancamento);
			}
			select.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public void inserir(Lancamento lancamento) {
		lancamento.getTipo().charAt(0);
		PreparedStatement insert;
		try {
			insert = conexao.prepareStatement("INSERT INTO LANCAMENTOS " + ""
					+ "(TIPO,DESCRICAO,VALOR) VALUES(?,?,?);");
			insert.setLong(1,  lancamento.getTipo().charAt(0));
			insert.setString(2,  lancamento.getDescricao());
			insert.setDouble(3,  lancamento.getValor().doubleValue());
			insert.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
