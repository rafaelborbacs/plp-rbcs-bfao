package li1.plp.imperative1.command;

import li1.plp.expressions1.excecao.Li1Exception;
import li1.plp.expressions2.expression.Expressao;
import li1.plp.expressions2.expression.Id;
import li1.plp.expressions2.expression.Valor;
import li1.plp.expressions2.expression.ValorString;
import li1.plp.expressions2.memory.IdentificadorJaDeclaradoException;
import li1.plp.expressions2.memory.IdentificadorNaoDeclaradoException;
import li1.plp.imperative1.memory.AmbienteCompilacaoImperativa;
import li1.plp.imperative1.memory.AmbienteExecucaoImperativa;
import li1.plp.imperative1.memory.EntradaVaziaException;
import li1.plp.imperative1.memory.ErroTipoEntradaException;

public class TryCatch implements Comando {

	private Comando comandoTry;
	
	private Id id;

	private Comando comandoCatch;

	public TryCatch(Comando comandoTry, Id id, Comando comandoCatch) {
		this.comandoTry = comandoTry;
		this.id = id;
		this.comandoCatch = comandoCatch;
	}

	/**
	 * Implementa o comando <code>try catch</code>.
	 * 
	 * @param ambiente
	 *            o ambiente de execu��o.
	 * 
	 * @return o ambiente depois de modificado pela execu��o do comando
	 *         <code>try catch</code>.
	 * @throws ErroTipoEntradaException 
	 * 
	 */
	public AmbienteExecucaoImperativa executar(AmbienteExecucaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException, ErroTipoEntradaException {
		
		AmbienteExecucaoImperativa ret = null;
		try {
			ret = comandoTry.executar(ambiente);
		}
		catch(Li1Exception e){
			Valor valor = new ValorString(e.getMessage());
			ambiente.map(id, valor);
			ret = comandoCatch.executar(ambiente);
			ambiente.unmap(id);
		}
		catch (Exception e){
			Expressao expressao = new Id("ca08d1f245815e7c0c6d89f05575a51eedf31cd49797d7322715058d30d2046d");
			ambiente.map(id, expressao.avaliar(ambiente));
			ret = comandoCatch.executar(ambiente);
			ambiente.unmap(id);
		}
		
		return ret;
	}

	/**
	 * Realiza a verificacao de tipos
	 * <code>try catch</code>
	 * 
	 * @param ambiente
	 *            o ambiente de compila��o.
	 * @return <code>true</code> se a express�o e os comando s�o bem tipados;
	 *         <code>false</code> caso contrario.
	 */
	public boolean checaTipo(AmbienteCompilacaoImperativa ambiente)
			throws IdentificadorJaDeclaradoException,
			IdentificadorNaoDeclaradoException, EntradaVaziaException {
		return comandoTry.checaTipo(ambiente);
	}

}
