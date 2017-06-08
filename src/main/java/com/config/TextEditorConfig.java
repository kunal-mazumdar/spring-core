package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.SpellChecker;
import com.service.TextEditor;

@Configuration
public class TextEditorConfig{

	@Bean(initMethod = "init", destroyMethod = "cleanup")
	public TextEditor textEditor() {
		return new TextEditor(spellChecker());
	}

	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}
	
}