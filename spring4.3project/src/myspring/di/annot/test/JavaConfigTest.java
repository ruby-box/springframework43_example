package myspring.di.annot.test;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;
import myspring.di.annot.config.HelloConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HelloConfig.class, 
	loader=AnnotationConfigContextLoader.class) /* Xml이 아닌, Java Config Class를 주입 */
public class JavaConfigTest {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	Hello hello;
	
	@Resource(name="sPrinter")
	Printer printer;
	
	@Test
	public void hello() {
		System.out.println(hello.sayHello());
		hello.print();
		System.out.println(printer.toString());
	}
	
	@Test @Ignore
	public void context() {
		System.out.println(context.getClass().getName());	//GenericApplicationContext
	}
}
