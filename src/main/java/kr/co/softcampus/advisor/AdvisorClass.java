package kr.co.softcampus.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdvisorClass {
	
	// 관심사 동작 이전에 호출된다.
	@Before("execution(* method1())")
	public void beforeMethod() {
		System.out.println("beforeMethod 호출");
	}
	
	// 관심사 동작 이후에 호출된다.
	@After("execution(* method1())")
	public void afterMethod() {
		System.out.println("afterMethod 호출");
	}
	
	// 관심사 동작 이전 이후를 의미한다.
	@Around("execution(* method1())")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("aroundMethod 호출 1");
		Object result = pjp.proceed();
		System.out.println("aroundMethod 호출 2");
		return result;
	}
	
	// 예외 없이 정상적으로 종료되었을 때 호출된다.
	@AfterReturning("execution(* method1())")
	public void afterReturningMethod() {
		System.out.println("afterReturning 호출");
	}
	
	// 예외가 발생하여 종료되었을 때 호출된다. 
	@AfterThrowing("execution(* method1())")
	public void afterThrowingMethod() {
		System.out.println("afterThrowing 호출");
	}
}