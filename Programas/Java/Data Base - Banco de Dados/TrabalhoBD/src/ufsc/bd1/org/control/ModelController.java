package ufsc.bd1.org.control;

import java.util.List;
import java.util.Map;

//import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ModelController implements IController {

	private Session session;

	public ModelController() {
		this.session = GeneralController.getSession();
	}
	
	public Session getSession() {
		return session;
	}

	public void insert(Object object) {		
		this.session.beginTransaction();
//		this.session.persist(object);
		this.session.merge(object);
		this.session.getTransaction().commit();
	}

	public void update(Object object) {
		this.session.beginTransaction();
		this.session.merge(object);
		this.session.getTransaction().commit();
	}

	public void delete(Object object) {
		this.session.beginTransaction();
		this.session.delete(object);
		this.session.getTransaction().commit();
	}
	
	public List<?> list(Class<?> iClass) {
		return (List<?>) this.session.createCriteria(iClass).list();
	}

	public Object getByCode(Class<?> iClass, Integer id) {
		return this.session.get(iClass, id);
	}
	
	public void deleteAll() {
		this.session.beginTransaction();
		
		this.session.createSQLQuery("delete from fornecedorcomponente").executeUpdate();
		this.session.createSQLQuery("delete from pedidocomponente").executeUpdate();
		this.session.createSQLQuery("delete from solicita").executeUpdate();
		this.session.createSQLQuery("delete from recebe").executeUpdate();
		this.session.createSQLQuery("delete from utiliza").executeUpdate();
		this.session.createSQLQuery("delete from pessoaprojeto").executeUpdate();

		this.session.createSQLQuery("delete from solicitacao").executeUpdate();
		this.session.createSQLQuery("delete from pedido").executeUpdate();
		this.session.createSQLQuery("delete from funcao").executeUpdate();
		this.session.createSQLQuery("delete from tipopessoa").executeUpdate();
		this.session.createSQLQuery("delete from exemplar").executeUpdate();
		this.session.createSQLQuery("delete from projeto").executeUpdate();
		this.session.createSQLQuery("delete from pessoa").executeUpdate();
		this.session.createSQLQuery("delete from item").executeUpdate();
		this.session.createSQLQuery("delete from fornecedor").executeUpdate();

		
		this.session.getTransaction().commit();
		
		System.out.println("BANCO DE DADOS LIMPO");
	}
	public void updateTab(String sql){
		this.session.beginTransaction();
		this.session.createSQLQuery(sql).executeUpdate();
		this.session.getTransaction().commit();

	}
	
	public void deleteFromTab(String sql){
		this.session.beginTransaction();
		this.session.createSQLQuery(sql).executeUpdate();
		this.session.getTransaction().commit();

	}
	
	public void close() {
		this.session.close();
	}
	
	public List<?> query(String sql, Map<String,Integer> parameters,  Class<?> iClass) {
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(iClass);
		Integer value;
		for (String key : parameters.keySet()) {
			value = parameters.get(key);
			query.setParameter(key, value);
		}
		List<?> resultSet = query.list();
		return resultSet;
	}


}