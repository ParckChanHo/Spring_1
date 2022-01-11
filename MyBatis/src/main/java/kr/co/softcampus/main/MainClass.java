package kr.co.softcampus.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.softcampus.beans.JdbcBean;
import kr.co.softcampus.config.BeanConfigClass;
import kr.co.softcampus.mapper.MapperInterface;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		MapperInterface mapper = ctx.getBean("test_mapper",MapperInterface.class);
		
		// insert
		/*JdbcBean bean2 = new JdbcBean();
		bean2.setInt_data(100);
		bean2.setStr_data("문자열 100");
		mapper.insert_data(bean2);
		
		JdbcBean bean3 = new JdbcBean();
		bean3.setInt_data(200);
		bean3.setStr_data("문자열 200");
		mapper.insert_data(bean3);*/
		
		// update
		/*JdbcBean bean4 = new JdbcBean();
		bean4.setInt_data(100);
		bean4.setStr_data("문자열 300");
		mapper.insert_data(bean4);*/
		
		// delete
		mapper.delete_data(100);
		
		// select
		List<JdbcBean> list1 = mapper.select_data();
		for(JdbcBean bean1 : list1) {
			System.out.printf("int_data : %d\n", bean1.getInt_data());
			System.out.printf("str_data : %s\n", bean1.getStr_data());
			System.out.println("---------------------------------------");
		}
		
		
		
		ctx.close();
	}

}
