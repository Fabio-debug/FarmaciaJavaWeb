package br.com.farmacia.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Products;
import br.com.farmacia.domain.Providers;
import br.com.farmacia.factory.ConnectionFactory;

public class ProductsDAO {

	
	 public void salvar (Products p) throws SQLException {
			
		 	StringBuilder sql = new StringBuilder();		
			sql.append("INSERT INTO produtos ");
			sql.append("(descricao,  preco, quantidade, fornecedores) ");
			sql.append("VALUES(?,?,?,?)");
			
			Connection connection = ConnectionFactory.conectar();

			PreparedStatement comando = connection.prepareStatement(sql.toString());
			
			comando.setString(1, p.getDescricao());
			comando.setDouble(2, p.getPreco());
			comando.setLong(3, p.getQuantidade());
			comando.setString(4, p.getFornecedores());
			
			comando.executeUpdate();

		 	}
	 
	 	
	 	public ArrayList<Products> listar()throws SQLException {
		 		
	 		StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append("FROM produtos ");
			sql.append("ORDER BY descricao DESC ");
			
			Connection Conexao = ConnectionFactory.conectar();
			
			PreparedStatement comando = Conexao.prepareStatement(sql.toString());
			
			ResultSet resultado = comando.executeQuery();

			ArrayList<Products>listar = new ArrayList<Products>();
	 		
			while (resultado.next()){
				Products p = new Products();
				p.setCodigo(resultado.getLong("codigo"));
				p.setDescricao(resultado.getString("descricao"));
				p.setQuantidade(resultado.getInt("quantidade"));
				p.setPreco(resultado.getDouble("preco"));
				p.setFornecedores(resultado.getString("fornecedores"));
				
				listar.add(p);
			}
	 		return listar;
	 	}

	 
	 public void excluir (Products pro) throws SQLException {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM produtos");
			sql.append(" WHERE codigo = ?");
			
			Connection connection = ConnectionFactory.conectar();

			PreparedStatement comando = connection.prepareStatement(sql.toString());
			comando.setLong(1, pro.getCodigo());
			comando.executeUpdate();
		}
	 
		public void editar (Products pro) throws SQLException {
			
			StringBuilder sql = new StringBuilder();
		
			sql.append("UPDATE produtos ");
			sql.append("SET descricao = ?, quantidade = ?, preco = ?, fornecedores = ? ");
			sql.append("WHERE codigo = ?");
			
			Connection connection = ConnectionFactory.conectar();
			
			PreparedStatement comando = connection.prepareStatement(sql.toString());
			
			comando.setString(1,pro.getDescricao());
			comando.setLong(2,pro.getQuantidade());
			comando.setDouble(3,pro.getPreco());
			comando.setString(4,pro.getFornecedores());
			comando.setLong(5, pro.getCodigo());
			comando.executeUpdate();
		 	
		 	}

}
