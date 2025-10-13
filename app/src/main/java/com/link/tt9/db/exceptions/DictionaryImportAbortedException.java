package com.link.tt9.db.exceptions;

public class DictionaryImportAbortedException extends Exception{
	public DictionaryImportAbortedException() {
		super("Dictionary import stopped by request.");
	}
}
