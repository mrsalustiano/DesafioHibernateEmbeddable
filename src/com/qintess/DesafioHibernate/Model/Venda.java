package com.qintess.DesafioHibernate.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "venda")
public class Venda implements InterfaceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(mappedBy = "venda")
	private List<VendaItens> itens = new ArrayList<VendaItens>();

	@Column(name = "cliente_id", nullable = false)
	private int cliente_id;

	@Column(name = "desconto", nullable = false)
	private int desconto;

	@Column(name = "forma_de_pagamento", nullable = false)
	private int forma_de_pagamento;

	@Column(name = "data_pagamento", nullable = false)
	private Date data_pagamento;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "venda_id")
	private List<VendaItens> vendaItens;
	
	public Venda() {
	}

	public Venda(int cliente_id, int desconto, int forma_de_pagamento, Date data_pagamento) {
		this.cliente_id = cliente_id;
		this.desconto = desconto;
		this.forma_de_pagamento = forma_de_pagamento;
		this.data_pagamento = data_pagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public int getForma_de_pagamento() {
		return forma_de_pagamento;
	}

	public void setForma_de_pagamento(int forma_de_pagamento) {
		this.forma_de_pagamento = forma_de_pagamento;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public List<VendaItens> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(List<VendaItens> vendaItens) {
		this.vendaItens = vendaItens;
	}

	public void addVendaItens(VendaItens vendaItens) {
		if (this.vendaItens == null) {
			this.vendaItens = new ArrayList<VendaItens>();
		}
		this.vendaItens.add(vendaItens);
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", cliente_id=" + cliente_id + ", desconto=" + desconto + ", forma_de_pagamento="
				+ forma_de_pagamento + ", data_pagamento=" + data_pagamento + "]";
	}

}
