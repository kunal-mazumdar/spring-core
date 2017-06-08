package com.service;

public class TextEditor {
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}

	/* Bean Lifecycle Methods */
	public void init() {
		System.out.println("TextEditor : init invoked.");
	}

	public void cleanup() {
		System.out.println("TextEditor : cleanup invoked.");
	}
}