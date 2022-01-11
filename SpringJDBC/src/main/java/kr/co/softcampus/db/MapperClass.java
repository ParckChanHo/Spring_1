package kr.co.softcampus.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.softcampus.beans.JdbcBean;

@Component
public class MapperClass implements RowMapper<JdbcBean> {
	// mapRow 메소드 Override를 해주어야 한다.
	public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// ResultSet rs ==> Select문을 수행한 결과이다.
		
		JdbcBean bean = new JdbcBean();
		bean.setInt_data(rs.getInt("int_data"));
		bean.setStr_data(rs.getString("str_data"));
		
		
		return bean;
	}
}
