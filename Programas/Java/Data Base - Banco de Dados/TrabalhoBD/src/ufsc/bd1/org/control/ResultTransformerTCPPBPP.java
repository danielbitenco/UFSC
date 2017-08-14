package ufsc.bd1.org.control;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

import ufsc.bd1.org.model.BuscaPessoaProjeto;

public class ResultTransformerTCPPBPP implements ResultTransformer {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public List<?> transformList( List arg0) {
		List<BuscaPessoaProjeto> list = new ArrayList<BuscaPessoaProjeto>();
		for (Object tcpp : arg0) {
			list.add((BuscaPessoaProjeto) tcpp);
		}
		return list;
	}

	public BuscaPessoaProjeto transformTuple(Object[] arg0, String[] arg1) {
		BuscaPessoaProjeto object = new BuscaPessoaProjeto();
		object.setNome((String) arg0[0]);
		object.setQuantidadePessoas((BigInteger) arg0[1]);
		return object;
	}
}