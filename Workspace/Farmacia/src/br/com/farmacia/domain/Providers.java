package br.com.farmacia.domain;

public class Providers {


		private Long codigo;
		private String descricao;
		
		public long getCodigo() {
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
		
		@Override
		public String toString() {
			String saida = codigo + " - " + descricao;
			return saida;
		}
	
}
