package com.link.tt9.languages.exceptions;

import com.link.tt9.languages.Language;

public class InvalidLanguageCharactersException extends Exception {

	public InvalidLanguageCharactersException(Language language, String extraMessage) {
		super("Some characters are not supported in language: " + language.getName() + ". " + extraMessage);
	}

}

