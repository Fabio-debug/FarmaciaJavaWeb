package br.com.farmacia.domain;

public class Products {

	private Long codigo;
	private String descricao;
	private int quantidade;
	private Double preco;
	private String fornecedores;
	
	public void setFornecedores(String fornecedores) {
		this.fornecedores = fornecedores;
	}
	public String getFornecedores() {
		return fornecedores;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
		
}