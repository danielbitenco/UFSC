package ufsc.bd1.org.control;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;

import ufsc.bd1.org.model.BuscaExemplaresQtdCustoUnTotal;

public class ResultSetControllerBEQCUT extends ModelController{

    @SuppressWarnings("unchecked")
	public List<BuscaExemplaresQtdCustoUnTotal> queryTCPP(String sql) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		query.setResultTransformer(new ResultTransformerTCPPBEQCUT());
        List<BuscaExemplaresQtdCustoUnTotal> resultSet = query.list();
		return resultSet;
	}
	
    @SuppressWarnings("unchecked")
	public List<BuscaExemplaresQtdCustoUnTotal> queryTCPP1(String sql) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		List<BuscaExemplaresQtdCustoUnTotal> finalSet = 
				new ArrayList<BuscaExemplaresQtdCustoUnTotal>();
		List<Object[]> resultSet = query.list();
        for (Object[] row : resultSet) {
        	BuscaExemplaresQtdCustoUnTotal tcpp = new BuscaExemplaresQtdCustoUnTotal();
        	tcpp.setDescricao((String)row[0]);
        	tcpp.setModelo((String)row[1]);
        	tcpp.setQuantidade((BigInteger)row[2]);
          	tcpp.setValorUnitario((double)row[3]);
        	tcpp.setValorTotal((double)row[4]);
        	finalSet.add(tcpp);
        }
		return finalSet;
	}
    
	public void queryTCPPUpdate(String sql) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		query.setResultTransformer(new ResultTransformerTCPPBIUPP());
	}

	
}
