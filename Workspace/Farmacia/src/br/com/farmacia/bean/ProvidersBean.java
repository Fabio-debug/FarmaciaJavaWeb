package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;




import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.ProvidersDAO;
import br.com.farmacia.domain.Providers;
import br.com.farmacia.util.JSFutil;

@ManagedBean(name = "MBProviders")
@ViewScoped
public class ProvidersBean {
	
	private Providers providers;
	private ArrayList<Providers>itens;
	private ArrayList<Providers>itensFiltrados;
	
	
	
	public ArrayList<Providers> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Providers> itens) {
		this.itens = itens;
	}

	public Providers getProviders() {
		return providers;
	}

	public void setProviders(Providers providers) {
		this.providers = providers;
	}

	
	public ArrayList<Providers> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Providers> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}


	@PostConstruct
	public void prepararPesquisa() {
		
		try {
			ProvidersDAO pdao = new ProvidersDAO();
			itens = pdao.listar();
		
		} catch (SQLException e) {
			JSFutil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}

	public void prepararNovo() {
		providers = new Providers();
	}

	public void novo () {
		
		try {
			ProvidersDAO pdao = new ProvidersDAO();
			pdao.salvar(providers);
	
			itens = pdao.listar();
			
			JSFutil.adicionarMensagemSucesso("Fornecedor Salvo com sucesso!");
		} catch (SQLException e) {
			JSFutil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
			
	}


	public void excluir () {
		try {
			ProvidersDAO pdao = new ProvidersDAO();
			pdao.excluir(providers);
			
			itens = pdao.listar();
			
			JSFutil.adicionarMensagemSucesso("Fornecedor Exluido com sucesso!");
		
		} catch (SQLException e) {
		
			JSFutil.adicionarMensagemErro("N�o e possivel excluir um fornecedor, com produtos cadastrado associado ao fornecedor"); 
			e.printStackTrace();
		
		}
			
	}


	public void editar () {
		try {
			ProvidersDAO pdao = new ProvidersDAO();
			pdao.editar(providers);
			
			itens = pdao.listar();
			
			JSFutil.adicionarMensagemSucesso("Fornecedor Editado com sucesso!");
		
		} catch (SQLException e) {
		
			JSFutil.adicionarMensagemErro("ex.getMessage()"); 
			e.printStackTrace();
		
		}
			
	}	

}
