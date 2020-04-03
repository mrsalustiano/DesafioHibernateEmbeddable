package com.qintess.DesafioHibernate.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class FornecedorHasProdutoId implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1526130622488219111L;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Fornecedor fornecedor;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Produto produto;

	public FornecedorHasProdutoId() {
	}

	public FornecedorHasProdutoId(Fornecedor fornecedor, Produto produto) {
		this.fornecedor = fornecedor;
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		FornecedorHasProdutoId other = (FornecedorHasProdutoId) obj;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FornecedorHasProdutoId [fornecedor=" + fornecedor + ", produto=" + produto + "]";
	}


}