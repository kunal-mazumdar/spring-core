package com.entry;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.ApplicationContextStartConfig;
import com.config.ApplicationContextStopConfig;
import com.config.CalculatorConfig;
import com.config.TextEditorConfig;
import com.service.Calculator;
import com.service.TextEditor;

/**
 * @author KunalMZ
 * 
 */
public class Runner {

	public static void main(String[] args) {

		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
			
			ctx.register(TextEditorConfig.class, CalculatorConfig.class);
			
			/* Event Registered */
			ctx.register(ApplicationContextStartConfig.class, ApplicationContextStopConfig.class);
			
			ctx.refresh();
			
			ctx.start();

			TextEditor te = ctx.getBean(TextEditor.class);
			te.spellCheck();
			
			/**
			 * calc != cal1 due to Bean @scope set to Prototype in calculatorConfig.class
			 */
			Calculator calc = ctx.getBean(Calculator.class);
			calc.setNumbers(1, 2);
			calc.getNumbers();
			
			Calculator calc1 = ctx.getBean(Calculator.class);
			calc1.getNumbers();
			
			ctx.stop();
			
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Runner Closed");
			
			// Alternative of ctx.close() and in our case auto closing by try block
			// Performs when JVM is about to be shutdown rather than immediately
			// Both .close() and .registerShutdownHook() invokes the doClose() method ultimately
			// ctx.registerShutdownHook();
		}
	}
}
