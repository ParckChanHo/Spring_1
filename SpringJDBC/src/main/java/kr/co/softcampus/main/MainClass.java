package kr.co.softcampus.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.softcampus.beans.JdbcBean;
import kr.co.softcampus.config.BeanConfigClass;
import kr.co.softcampus.db.JdbcDAO;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		// dao를 가져온다.
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);
		
		JdbcBean bean1 = new JdbcBean();
		bean1.setInt_data(1);
		bean1.setStr_data("문자열1");
		dao.insert_data(bean1);
		
		JdbcBean bean2 = new JdbcBean();
		bean2.setInt_data(2);
		bean2.setStr_data("문자열2");
		dao.insert_data(bean2);
		
		System.out.println("저장완료")
		;
		ctx.close();
	}

}
