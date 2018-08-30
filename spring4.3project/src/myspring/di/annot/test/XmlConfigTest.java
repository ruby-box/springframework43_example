package myspring.di.annot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:myspring/di/annot/conf/beans.xml") /* xml 설정 명시 */
public class XmlConfigTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void context() {
		System.out.println(context.getClass().getName());
	}
}
