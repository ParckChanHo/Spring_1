package kr.co.softcampus.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"kr.co.softcampus.beans","kr.co.softcampus.db"})
public class BeanConfigClass {
	
	@Bean
	// DataSource
	public BasicDataSource source() {
		BasicDataSource source = new BasicDataSource();
		// 데이터베이스 접속정보
		source.setDriverClassName("oracle.jdbc.OracleDriver");
		source.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		// 계정이름
		source.setUsername("scott");
		source.setPassword("1234");
		
		return source;
	}
	
	// 데이터베이스에 접속하여서 쿼리를 전달하는 빈을 등록한다.
	// JdbcTemplate 클래스는 SQL 쿼리문을 손쉽게 구현할 수 있도록 구현이 되어있다.
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		// 데이터 소스 (데이터베이스 접속정보를 가지고 있는 객체를 의미한다. - DBCP)
		// 이 빈이 등록이 될 때 BasicDataSource source() 메소드에서 반환을 한 BasicDataSource 객체가 매개변수에 자동으로 
		// 주입이 된다.
		JdbcTemplate db = new JdbcTemplate(source);
		return db;
	}
}
