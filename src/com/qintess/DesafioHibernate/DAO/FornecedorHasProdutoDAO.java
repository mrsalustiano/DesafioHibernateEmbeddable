package com.qintess.DesafioHibernate.DAO;

import org.hibernate.Session;

import com.qintess.DesafioHibernate.Config.HibernateConfig;
import com.qintess.DesafioHibernate.Model.Fornecedor;
import com.qintess.DesafioHibernate.Model.FornecedorHasProduto;
import com.qintess.DesafioHibernate.Model.FornecedorHasProdutoId;
import com.qintess.DesafioHibernate.Model.Produto;

public class FornecedorHasProdutoDAO {


	public FornecedorHasProduto getByCompositeId(Integer idFornecedor, Integer idProduto) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			Fornecedor fornecedor = session.find(Fornecedor.class, idFornecedor);
			Produto produto = session.find(Produto.class, idProduto);
			return session.find(FornecedorHasProduto.class, new FornecedorHasProdutoId(fornecedor, produto));
		}
	}

}
