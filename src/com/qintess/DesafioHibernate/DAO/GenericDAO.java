package com.qintess.DesafioHibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.DesafioHibernate.Config.HibernateConfig;
import com.qintess.DesafioHibernate.Model.Fornecedor;
import com.qintess.DesafioHibernate.Model.InterfaceModel;

public class GenericDAO<T extends InterfaceModel> {

	public void salvar(T objeto) {
		Transaction transacao = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transacao = session.beginTransaction();
		
				session.save(objeto);
			

			transacao.commit();
			session.close();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			e.printStackTrace();
		}
		
	}


	
	public List<T> listaTodos(Class<T> clazz){
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		return (List<T>) session.createQuery("select t from " + clazz.getSimpleName() + " t order by id",clazz).getResultList();

	}
	
	public T listaPorId(Class<T> clazz, Object id) {

		Session session = HibernateConfig.getSessionFactory().openSession();
		try {
			return session.find(clazz, id);
	
		} finally {
			session.close();
		}
		
	}
	
	public void remove(Class<T> clazz, Object id){
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		T t = listaPorId(clazz, id);
		try{
			session.getTransaction().begin();
			session.remove(t);
			session.getTransaction().commit();
		}catch (Exception e) {
			
			session.getTransaction().rollback();
		}
	}



	public Fornecedor listaPorId(Class<Fornecedor> class1, int id) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		try {
			return session.find(class1, id);
	
		} finally {
			session.close();
		}
	}
}
