package com.qintess.DesafioHibernate.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements InterfaceModel {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int FornecedorID;

	@Column(name = "nome", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "telefone", length = 45, nullable = false)
	private String telefone;
	
	@Column(name = "contato", length = 45, nullable = false)
	private String contato;

		
	public Fornecedor() {

	}

	public Fornecedor(String nome, String telefone, String contato) {

		this.nome = nome;
		this.telefone = telefone;
		this.contato = contato;
	}

	@Override
	public Integer getId() {
		return FornecedorID;
	}

	public void setId(int id) {
		this.FornecedorID = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + FornecedorID + ", nome=" + nome + ", telefone=" + telefone + ", contato=" + contato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + FornecedorID;
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
		Fornecedor other = (Fornecedor) obj;
		if (FornecedorID != other.FornecedorID)
			return false;
		return true;
	}
	
	
	
	
}
