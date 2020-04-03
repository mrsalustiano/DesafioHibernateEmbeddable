package com.qintess.DesafioHibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "produto")
public class Produto implements InterfaceModel  {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Id
	private int ProdutoID;


	@Column(name = "preco_venda", nullable = false, precision = (2), length = 10)
	private double preco_venda;

	@Column(name = "min_estoque", nullable = false)
	private int min_estoque;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "foto", nullable = true)
	private String foto;



	 
	public Produto() {
	}

	public Produto(double preco_venda, int min_estoque, String nome, String foto) {
		this.preco_venda = preco_venda;
		this.min_estoque = min_estoque;
		this.nome = nome;
		this.foto = foto;
	}

	public Integer getId() {
		return ProdutoID;
	}

	public void setId(int id) {
		this.ProdutoID = id;
		
	}

	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public int getMin_estoque() {
		return min_estoque;
	}

	public void setMin_estoque(int min_estoque) {
		this.min_estoque = min_estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Produto [id=" + ProdutoID + ", preco_venda=" + preco_venda + ", min_estoque=" + min_estoque + ", nome=" + nome
				+ ", foto=" + foto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ProdutoID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (ProdutoID != other.ProdutoID)
			return false;
		return true;
	}

	
}
