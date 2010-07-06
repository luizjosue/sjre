package br.ufal.tci.messages;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageReader {

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle("br.ufal.tci.messages.message");

	private MessageReader() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static void main(String[] args) {

	}
}
