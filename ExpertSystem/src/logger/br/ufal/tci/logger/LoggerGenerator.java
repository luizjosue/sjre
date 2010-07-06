package br.ufal.tci.logger;

import java.io.File;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

import br.ufal.tci.util.StringUtil;

/**
 */
public final class LoggerGenerator {

	/** Fim de linha da plataforma atual */
	public final static String NL = File.separator.equals("/") ? "\n" : "\r\n";

	private final static Logger logger = Logger.getLogger("br.ufal.tci");

	// private final static Logger logger =
	// Logger.getLogger("org.apache.log4j.FileAppender");

	public static void error(String mensagem) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.error(mensagem);
		}
	}

	public static void error(String mensagem, Exception _exception) {
		if (!StringUtil.isEmpty(mensagem)) {
			ExceptionWriter writer = new ExceptionWriter();
			_exception.printStackTrace(writer);
			logger.error(mensagem + NL + writer.getBuffer());
		}
	}

	public static void error(String mensagem, Throwable _exception) {
		if (!StringUtil.isEmpty(mensagem)) {
			ExceptionWriter writer = new ExceptionWriter();
			_exception.printStackTrace(writer);
			logger.error(mensagem + NL + writer.getBuffer());
		}
	}

	public static void error(Class<?> classe, String metodo, String mensagem) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.error("::: [" + classe.getName() + "." + metodo + "] --> "
					+ mensagem + " :::");
		}
	}

	public static void error(Class<?> classe, String metodo,
			Exception _exception) {
		error(classe, metodo, "Erro ao realizar operação.", _exception);
	}

	public static void error(Class<?> classe, String metodo, String mensagem,
			Exception _exception) {
		if (!StringUtil.isEmpty(mensagem)) {
			ExceptionWriter writer = new ExceptionWriter();
			_exception.printStackTrace(writer);
			logger.error("::: [" + classe.getName() + "." + metodo + "] --> "
					+ mensagem + NL + writer.getBuffer() + " :::");
		}
	}

	public static void info(String mensagem) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.info(mensagem);
		}
	}

	public static void debug(Object object) {
		if (object != null) {
			logger.debug(object.toString());
		} else {
			logger.debug("null");
		}
	}

	public static void debug(String mensagem) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.debug(mensagem);
		}
	}

	public static void debug(String mensagem, Exception _exception) {
		if (!StringUtil.isEmpty(mensagem)) {
			ExceptionWriter writer = new ExceptionWriter();
			_exception.printStackTrace(writer);
			logger.debug(mensagem + NL + writer.getBuffer());
		}
	}

	public static void debug(String mensagem, Object p0) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.debug(MessageFormat.format(mensagem, new Object[] { p0 }));
		}
	}

	public static void debug(String mensagem, Object p0, Object p1) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.debug(MessageFormat
					.format(mensagem, new Object[] { p0, p1 }));
		}
	}

	public static void debug(String mensagem, Object p0, Object p1, Object p2) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.debug(MessageFormat.format(mensagem, new Object[] { p0, p1,
					p2 }));
		}
	}

	public static void debug(String mensagem, Object[] parametros) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.debug(MessageFormat.format(mensagem, parametros));
		}
	}

	public static void debug(Class<?> classe, String metodo, String mensagem) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.debug("::: [" + classe.getName() + "." + metodo + "] --> "
					+ mensagem + " :::");
		}
	}

	public static void debug(Class<?> classe, String metodo, String mensagem,
			Exception _exception) {
		if (!StringUtil.isEmpty(mensagem)) {
			ExceptionWriter writer = new ExceptionWriter();
			_exception.printStackTrace(writer);
			logger.debug("::: [" + classe.getName() + "." + metodo + "] --> "
					+ mensagem + NL + writer.getBuffer() + " :::");
		}
	}

	public static void infoAudit(String mensagem) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.info(mensagem);
		}
	}

	public static void infoTratar(String mensagem) {
		if (!StringUtil.isEmpty(mensagem)) {
			logger.info(mensagem);
		}
	}
}