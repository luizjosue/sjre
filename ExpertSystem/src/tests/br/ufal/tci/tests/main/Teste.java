/*
 * Created on 01/09/2004
 */
package br.ufal.tci.tests.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import br.ufal.tci.InferenceEngine.InferenceEngineImpl;
import br.ufal.tci.InferenceEngine.InterpreterImpl;
import br.ufal.tci.InferenceEngine.KnowledgeBaseImpl;
import br.ufal.tci.exception.MissingElementException;
import br.ufal.tci.exception.SemanticException;
import br.ufal.tci.exception.SyntaticException;
import br.ufal.tci.logger.LoggerGenerator;
import br.ufal.tci.trace.TracerImpl;
import br.ufal.tci.util.Pair;
import br.ufal.tci.value.Value;

/**
 * @author ljsf
 * 
 */
public class Teste {

	public Teste() {
		System.out.println("teste de instanciacao");
	}

	public static void main(String[] args) {

		String fileName;
		InterpreterImpl interpreter;
		InferenceEngineImpl engine;

		fileName = "./doc/teste.p1";

		try {
			LoggerGenerator.info("Antes");
			interpreter = new InterpreterImpl(new FileInputStream(fileName));
			LoggerGenerator.info("Depois 1");
			engine = new InferenceEngineImpl(interpreter, KnowledgeBaseImpl
					.getInstance());
			engine.setTracer(TracerImpl.getInstance());
			interpreter.createParserTree(engine);

			LoggerGenerator.info("Antes dos fatos serem disparados");
			engine.loadFacts();
			LoggerGenerator.info("Depois dos fatos serem disparados");

			provar("var1", engine);
			provar("var2", engine);
			provar("var3", engine);
			provar("var4", engine);
			provar("gaguinho", engine);
			provar("abc", engine);
			provar("foo", engine);
			provar("foobar", engine);
			provar("testeDeOrdem", engine);
			provar("var1", engine);
			provar("str", engine);
			provar("testeObj", engine);

			/*
			 * List variables = KnowledgeBase.getInstance().getAllVariables();
			 * Iterator iterator = variables.iterator(); Variable variable;
			 * 
			 * while(iterator.hasNext()){ variable = (Variable)iterator.next();
			 * System
			 * .out.println("Variável: "+variable.getIdentifier()+" Valores: "
			 * +variable.getValue()); }
			 */

		} catch (SemanticException e) {
			LoggerGenerator.info(e.getMessage());
		} catch (SyntaticException e) {
			LoggerGenerator.info(e.getMessage());
		} catch (FileNotFoundException e) {
			LoggerGenerator.info(e.getMessage());
		} catch (MissingElementException e) {
			LoggerGenerator.info(e.getMessage());
		}

		/*
		 * String fileName; Parser_1 parser; ASTStart start; Parser_1Visitor
		 * visitor;
		 * 
		 * try{ fileName = "./doc/teste.p1";
		 * 
		 * start = parser.Start(new InferenceEngine(new Interpreter(),
		 * KnowledgeBase.getInstance())); visitor = new Parser_1DumpVisitor();
		 * 
		 * try{ start.jjtAccept(visitor, null); Program program =
		 * Program.Instance();
		 * 
		 * Collection collection =
		 * program.getFactDeclaration().getListOfFacts(); Iterator iterator =
		 * collection.iterator(); Fact fact = null;
		 * 
		 * while(iterator.hasNext()){ fact = (Fact)iterator.next();
		 * LoggerGenerator.debug(fact.evaluate(new TesteEngine())); }
		 * 
		 * collection = program.getRuleDeclaration().getListOfRules(); iterator
		 * = collection.iterator(); Rule rule = null;
		 * 
		 * while(iterator.hasNext()){ rule = (Rule)iterator.next();
		 * rule.fire(new TesteEngine()); } } catch (SemanticException e){
		 * LoggerGenerator.debug(e.getMessage()); }
		 * 
		 * 
		 * } catch (FileNotFoundException e){
		 * LoggerGenerator.debug("Excessao: "+e.getMessage()); } catch
		 * (ParseException e){
		 * LoggerGenerator.debug("Excessao: "+e.getMessage()); }/ catch
		 * (MyException e){ LoggerGenerator.debug("Excessao: "+e.getMessage());
		 * }
		 */
	}

	private static void provar(String var, InferenceEngineImpl engine)
			throws MissingElementException, SemanticException {
		Object p = engine.findValue(engine.findVariable(var, engine));
		if (p instanceof Pair) {
			Pair<?> pair = (Pair<?>) p;
			p = pair.getObject1();
		} else if (p instanceof Value) {
			p = ((Value<?>) p).toString();
		}
		if (p != null) {
			LoggerGenerator.info("Conseguiu provar " + var + ", valor: "
					+ p.toString());
		} else {
			LoggerGenerator.info("Não conseguiu provar " + var + ".");
		}
		LoggerGenerator.info(TracerImpl.getInstance().getMessage());
	}

	public static String foobar() {
		return "foobar moral!!";
	}
}
