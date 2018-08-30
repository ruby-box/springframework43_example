package myspring.di.annot.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:myspring/di/annot/conf/beans.xml") /* xml 설정 명시 */
public class XmlConfigTest {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	Hello hello;
	
	//@Autowired
	//@Qualifier("sPrinter")
	
	@Resource(name="sPrinter") /* Autowired + Qualifier 의존 관계 객체를 찾아서 주입 */
	Printer printer;
	
	@Test
	public void hello() {
		Assert.assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 어노테이션", printer.toString());
	}
	
	@Test
	public void context() {
		System.out.println(context.getClass().getName());
	}
}
