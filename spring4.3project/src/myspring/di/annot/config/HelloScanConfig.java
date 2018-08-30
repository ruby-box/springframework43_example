package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"myspring.di.annot"}) /* <context:component-scan base-package="myspring.di.annot"/> 대체 JavaConfig*/
/* 컴포넌트 클래스 하나씩 Bean생성하지 않고  한번에 생성해서 가져오기 */
public class HelloScanConfig {
	
}
