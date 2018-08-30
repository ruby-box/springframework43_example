package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("cPrinter")
public class ConsolePrinter implements Printer {
	public void print(String message) {
		System.out.println(message);
	}
}
