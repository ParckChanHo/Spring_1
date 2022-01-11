package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softcampus.beans.JdbcBean;

// Class가 아니라 interface 이기 때문에 Bean으로 등록을 시켜주지 못한다.
public interface MapperInterface {
	
	/*@Results({
		@Result(column = "int_data",property = "int_data"),
		@Result(column = "str_data",property = "str_data")
	})
	주석 처리를 해도 정상적으로 잘 작동을 한다.
	*/
	// column의 이름과 property(변수의 이름)의 이름이 같으면 자동으로 주입을 해준다.
	// 따라서 column의 이름과 property의 이름이 다른 것들만 아래와 같이 해주면 된다.
	
	/*
	 ex) 예를 들어서....
	@Results({
		@Result(column = "different_data_1",property = "int_data"),
		@Result(column = "different_data_2",property = "str_data")
	})
	
	*/
	@Select("select int_data, str_data from jdbc_table")
	// select_data() 메소드를 호출하면 위의 쿼리문이 실행이 된다.
	List<JdbcBean> select_data();
	
	//매개변수 JdbcBean bean의 변수에 들어있는 값이 각각 #{int_data},#{str_data}에 들어간다.
	// private int int_data; ===> #{int_data}
	// private String str_data; ===> #{str_data}
	@Insert("insert into jdbc_table (int_data, str_data) values (#{int_data},#{str_data})")
	void insert_data(JdbcBean bean);
	
	//매개변수 JdbcBean bean의 변수에 들어있는 값이 각각 #{int_data},#{str_data}에 들어간다.
	// private int int_data; ===> #{int_data}
	// private String str_data; ===> #{str_data}
	@Update("update jdbc_table set str_data = #{str_data} where int_data = #{int_data}")
	void update_data(JdbcBean bean);
	
	// #{abc} ===> 이 부분은 아무거나 집어 넣어도 괜찮다. 즉 abc가 아니라 #{qweasdas} 여도 상관이 없다.
	@Delete("delete from jdbc_table where int_data = #{abc}")
	void delete_data(int int_data);
	
	
	
	
	
}
