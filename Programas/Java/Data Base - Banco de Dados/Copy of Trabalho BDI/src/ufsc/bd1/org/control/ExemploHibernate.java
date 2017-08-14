package ufsc.bd1.org.control;


import ufsc.bd1.org.control.ModelController;
import ufsc.bd1.org.model.Fornecedor;



public class ExemploHibernate {

	private ModelController modelCtr = new ModelController();

	public void close() {
		modelCtr.close();
	}

	public void inserts() {

		Fornecedor pac1 = new Fornecedor(1,"luiz da ovelhas","rua das ovelhas","luiz da ovelhas");
//		pac1.setId(1);
		
		modelCtr.insert(pac1);

		System.out.println("Inser realizazadas com sucesso!!!");

	}


	public static void main(String[] args) {
		
		ExemploHibernate ex = new ExemploHibernate();
		ex.inserts();
//		ex.close();
	}

}



// 
//import java.util.List;
// 
//import org.hibernate.Query;
//import org.hibernate.Session;
//
//import ufsc.bd1.org.model.Fornecedor;
// 
// 
//public class ExemploHibernate {
// 
//    public static void main(String[] args) {
//        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
// 
//        session.beginTransaction();
// 
//        createPerson(session);
// 
//
//    }
// 
//
////    }
// 
//    public static void createPerson(Session session) {
//		Fornecedor pac1 = new Fornecedor(1,"luiz da ovelhas","rua das ovelhas","luiz da ovelhas");
//  
//        session.save(pac1);
//    }
//}