package kr.co.softcampus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"kr.co.softcampus.beans,'kr.co.softcampus.advisor"})
// advisor 클래스에 실행되어 있는 Annotation을 분석하여서 AOP 셋팅(Setting)을 해라 
@EnableAspectJAutoProxy
public class BeanConfigClass {

}
