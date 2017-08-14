package ufsc.bd1.org.control;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;

import ufsc.bd1.org.model.BuscaItensUtilizadosPessoasProjetos;


public class ResultSetControllerBIUPP extends ModelController{

    @SuppressWarnings("unchecked")
	public List<BuscaItensUtilizadosPessoasProjetos> queryTCPP(String sql) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		query.setResultTransformer(new ResultTransformerTCPPBIUPP());
        List<BuscaItensUtilizadosPessoasProjetos> resultSet = query.list();
		return resultSet;
	}
	
    @SuppressWarnings("unchecked")
	public List<BuscaItensUtilizadosPessoasProjetos> queryTCPP1(String sql) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		List<BuscaItensUtilizadosPessoasProjetos> finalSet = 
				new ArrayList<BuscaItensUtilizadosPessoasProjetos>();
		List<Object[]> resultSet = query.list();
        for (Object[] row : resultSet) {
        	BuscaItensUtilizadosPessoasProjetos tcpp = new BuscaItensUtilizadosPessoasProjetos();
        	tcpp.setQuemUsa((String)row[0]);
        	tcpp.setQtdComponente((BigInteger)row[1]);
          	tcpp.setTipo((String)row[2]);
        	finalSet.add(tcpp);
        }
		return finalSet;
	}
    
 
}
