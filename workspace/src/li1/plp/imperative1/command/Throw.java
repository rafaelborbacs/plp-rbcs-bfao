package li1.plp.imperative1.command;

import li1.plp.expressions1.excecao.Li1Exception;
import li1.plp.expressions2.expression.Expressao;
import li1.plp.expressions2.expression.Id;
import li1.plp.expressions2.expression.Valor;
import li1.plp.expressions2.memory.VariavelJaDeclaradaException;
import li1.plp.expressions2.memory.VariavelNaoDeclaradaException;
import li1.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li1.plp.imperative1.memory.AmbienteExecucaoImperativa;

public class Throw implements Comando {

	private Expressao expressao;

	public Throw(Expressao expressao) {
		this.expressao = expressao;
	}

	/**
	 * Salva a express�o numa vari�vel especial e levanta a Exception
	 * 
	 * @param ambiente
	 *            o ambiente de execu��o.
	 * 
	 * @return o ambiente depois de modificado pela execu��o do comando
	 *         <code>throw</code>.
	 * 
	 */
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException, Li1Exception {
		
		Id id = new Id("ca08d1f245815e7c0c6d89f05575a51eedf31cd49797d7322715058d30d2046d");
		Valor valor = expressao.avaliar(ambiente);
		ambiente.map(id, valor);
		throw new Li1Exception(valor.toString());
	}

	/**
	 * Realiza a verificacao de tipos da express�o a ser enviada ao
	 * <code>throw</code>
	 * 
	 * @param ambiente
	 *            o ambiente de compila��o.
	 * @return <code>true</code> se a express�o a ser escrita est� bem tipada;
	 *         <code>false</code> caso contrario.
	 */
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {
		return expressao.checaTipo(ambiente);
	}

}
