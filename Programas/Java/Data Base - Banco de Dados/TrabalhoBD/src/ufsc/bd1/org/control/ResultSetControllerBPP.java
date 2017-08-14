package ufsc.bd1.org.control;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;

import ufsc.bd1.org.model.BuscaPessoaProjeto;

public class ResultSetControllerBPP extends ModelController {

    @SuppressWarnings("unchecked")
	public List<BuscaPessoaProjeto> queryTCPP(String sql) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		query.setResultTransformer(new ResultTransformerTCPPBPP());
        List<BuscaPessoaProjeto> resultSet = query.list();
		return resultSet;
	}
	
    @SuppressWarnings("unchecked")
	public List<BuscaPessoaProjeto> queryTCPP1(String sql) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		List<BuscaPessoaProjeto> finalSet = 
				new ArrayList<BuscaPessoaProjeto>();
		List<Object[]> resultSet = query.list();
        for (Object[] row : resultSet) {
        	BuscaPessoaProjeto tcpp = new BuscaPessoaProjeto();
        	tcpp.setNome((String)row[0]);
        	tcpp.setQuantidadePessoas((BigInteger)row[1]);
        	finalSet.add(tcpp);
        }
		return finalSet;
	}

	
}