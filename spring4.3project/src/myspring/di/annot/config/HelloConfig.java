package myspring.di.annot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.annot.ConsolePrinter;
import myspring.di.annot.Hello;
import myspring.di.annot.Printer;
import myspring.di.annot.StringPrinter;

@Configuration
public class HelloConfig {
	
	/*Java Configuration 은 객체 생성을 직접 해준다. */
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		return hello;
	}
	
	@Bean
	@Qualifier("sPrinter") /* Printer로 구현하는 클래스가 여러개 있기 때문에 Unique하게 구분할 수 있는 key 부여 */
	public Printer sPrinter() {
		Printer sPrinter = new StringPrinter();
		return sPrinter;
	}
	
	@Bean
	@Qualifier("cPrinter") /* Printer로 구현하는 클래스가 여러개 있기 때문에 Unique하게 구분할 수 있는 key 부여 */
	public Printer cPrinter() {
		Printer cPrinter = new ConsolePrinter();
		return cPrinter;
	}
	
}
