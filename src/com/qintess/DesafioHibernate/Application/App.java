package com.qintess.DesafioHibernate.Application;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import com.qintess.DesafioHibernate.DAO.GenericDAO;
import com.qintess.DesafioHibernate.Model.Fornecedor;
import com.qintess.DesafioHibernate.Model.FornecedorHasProduto;
import com.qintess.DesafioHibernate.Model.Produto;
import com.qintess.DesafioHibernate.Model.Venda;
import com.qintess.DesafioHibernate.Model.VendaItens;

public class App {


	public static void main(String[] args) throws Exception {

		System.out.println("Testando Criacao Tables");

		// PRODUTO 
		GenericDAO<Produto> daoProduto = new GenericDAO<Produto>();
		GenericDAO<Venda> daoVenda = new GenericDAO<Venda>();
		GenericDAO<Fornecedor> daoFornecedor = new GenericDAO<Fornecedor>();
		GenericDAO<VendaItens> daoVendaItens = new GenericDAO<VendaItens>();
		GenericDAO<FornecedorHasProduto> daoFornecedorHasProduto = new GenericDAO<FornecedorHasProduto>();

		Produto produto1 = new Produto(2500.0, 10, "PS4", "foto");
		Produto produto2 = new Produto(5500.0,10,"PS5", "FOTO");
		Produto produto3 = new Produto(2500.0, 10, "MI 9TPRO4", "foto");
		Produto produto4 = new Produto(1500.0, 10, "MI 9T", "foto");
		
		daoProduto.salvar(produto1);
		daoProduto.salvar(produto2);
		daoProduto.salvar(produto3);
		daoProduto.salvar(produto4);
		

		// Fornecedor

		Fornecedor fornecedor1 = new Fornecedor("FNAC", "11 2222-3333", "contato");
		Fornecedor fornecedor2 = new Fornecedor("KABOOM", "11 4444-5555", "contato");
		
		daoFornecedor.salvar(fornecedor1);
		daoFornecedor.salvar(fornecedor2);


		
		Fornecedor fornecedorBanco1  = daoProduto.listaPorId(Fornecedor.class, 1);
		Fornecedor fornecedorBanco2  = daoProduto.listaPorId(Fornecedor.class, 1);
		Produto produtoSalvo1 = daoProduto.listaPorId(Produto.class, 1);
		Produto produtoSalvo2 = daoProduto.listaPorId(Produto.class, 2);
		Produto produtoSalvo3 = daoProduto.listaPorId(Produto.class, 3);
		Produto produtoSalvo4 = daoProduto.listaPorId(Produto.class, 4);
		
		FornecedorHasProduto fornecedorHasProduto1 = new FornecedorHasProduto();
		FornecedorHasProduto fornecedorHasProduto2 = new FornecedorHasProduto();
		FornecedorHasProduto fornecedorHasProduto3 = new FornecedorHasProduto();
		FornecedorHasProduto fornecedorHasProduto4 = new FornecedorHasProduto();
		
		fornecedorHasProduto1.setId(new com.qintess.DesafioHibernate.Model.FornecedorHasProdutoId(fornecedorBanco1,produtoSalvo1));
		fornecedorHasProduto2.setId(new com.qintess.DesafioHibernate.Model.FornecedorHasProdutoId(fornecedorBanco1,produtoSalvo2));
		fornecedorHasProduto3.setId(new com.qintess.DesafioHibernate.Model.FornecedorHasProdutoId(fornecedorBanco2,produtoSalvo3));
		fornecedorHasProduto4.setId(new com.qintess.DesafioHibernate.Model.FornecedorHasProdutoId(fornecedorBanco2,produtoSalvo4));
		
		fornecedorHasProduto1.setEstoque(150);
		fornecedorHasProduto2.setEstoque(500);
		fornecedorHasProduto3.setEstoque(200);
		fornecedorHasProduto4.setEstoque(100);
		
		fornecedorHasProduto1.setPrecoCusto(2000.0);
		fornecedorHasProduto2.setPrecoCusto(4600.0);
		fornecedorHasProduto3.setPrecoCusto(12000.0);
		fornecedorHasProduto4.setPrecoCusto(7500.0);
		
		
		daoFornecedorHasProduto.salvar(fornecedorHasProduto1);
		daoFornecedorHasProduto.salvar(fornecedorHasProduto2);
		daoFornecedorHasProduto.salvar(fornecedorHasProduto3);
		daoFornecedorHasProduto.salvar(fornecedorHasProduto4);
		
		Venda venda1 = new Venda(1, 0, 1, Timestamp.valueOf(LocalDateTime.now()));
		Venda venda2 = new Venda(2, 0, 2, Timestamp.valueOf(LocalDateTime.now()));
		
		daoVenda.salvar(venda1);
		daoVenda.salvar(venda2);
		
		Venda vendaSalva1 = daoVenda.listaPorId(Venda.class, 1);
		Venda vendaSalva2 = daoVenda.listaPorId(Venda.class, 2);
		
		VendaItens vendaItens1 =  new VendaItens(vendaSalva1, produtoSalvo1, 23, fornecedorHasProduto1.getPrecoCusto(), 
				produtoSalvo1.getPreco_venda()); 
				
		VendaItens vendaItens2 = new VendaItens(vendaSalva2,produtoSalvo2, 57, fornecedorHasProduto2.getPrecoCusto(), 
				produtoSalvo2.getPreco_venda());
		
		VendaItens vendaItens3 = new VendaItens(vendaSalva1,produtoSalvo3,  62, fornecedorHasProduto3.getPrecoCusto(), 
				produtoSalvo3.getPreco_venda());
		
		VendaItens vendaItens4 = new VendaItens(vendaSalva2,produtoSalvo3,  11, fornecedorHasProduto3.getPrecoCusto(), 
				produtoSalvo3.getPreco_venda());
		
		daoVendaItens.salvar(vendaItens1);
		daoVendaItens.salvar(vendaItens2);
		daoVendaItens.salvar(vendaItens3);
		daoVendaItens.salvar(vendaItens4);
		
		for(FornecedorHasProduto f : daoFornecedorHasProduto.listaTodos(FornecedorHasProduto.class)) {
			System.out.println("\n\n");
			System.out.print(f.getId().getFornecedor() + "\t");
			System.out.println(f.getId().getProduto());
			System.out.println("\n\n");
		}
		
		
		for(Venda v : daoVenda.listaTodos(Venda.class)) {
			System.out.println("\n\n");
			System.out.println(v);
			System.out.println(v.getVendaItens());
			System.out.println("\n\n");
		}
	}

	
	

	
}
