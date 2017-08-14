package ufsc.bd1.org.control;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

import ufsc.bd1.org.model.BuscaItensUtilizadosPessoasProjetos;


public class ResultTransformerTCPPBIUPP implements ResultTransformer{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public List<?> transformList( List arg0) {
		List<BuscaItensUtilizadosPessoasProjetos> list = new ArrayList<BuscaItensUtilizadosPessoasProjetos>();
		for (Object tcpp : arg0) {
			list.add((BuscaItensUtilizadosPessoasProjetos) tcpp);
		}
		return list;
	}

	public BuscaItensUtilizadosPessoasProjetos transformTuple(Object[] arg0, String[] arg1) {
		BuscaItensUtilizadosPessoasProjetos object = new BuscaItensUtilizadosPessoasProjetos();
		object.setQuemUsa((String) arg0[0]);
		object.setQtdComponente((BigInteger) arg0[1]);
		object.setTipo((String) arg0[2]);
		return object;
	}
}
