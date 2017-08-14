package ufsc.bd1.org.control;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

import ufsc.bd1.org.model.BuscaExemplaresQtdCustoUnTotal;


public class ResultTransformerTCPPBEQCUT implements ResultTransformer{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public List<?> transformList( List arg0) {
		List<BuscaExemplaresQtdCustoUnTotal> list = new ArrayList<BuscaExemplaresQtdCustoUnTotal>();
		for (Object tcpp : arg0) {
			list.add((BuscaExemplaresQtdCustoUnTotal) tcpp);
		}
		return list;
	}

	public BuscaExemplaresQtdCustoUnTotal transformTuple(Object[] arg0, String[] arg1) {
		BuscaExemplaresQtdCustoUnTotal object = new BuscaExemplaresQtdCustoUnTotal();
		object.setDescricao((String) arg0[0]);
		object.setModelo((String) arg0[1]);
		object.setQuantidade((BigInteger) arg0[2]);
		object.setValorUnitario((double) arg0[3]);
		object.setValorTotal((double) arg0[4]);
		return object;
	}
}
