package ec.aop;

import org.springframework.aop.ThrowsAdvice;

public class ThrowException implements ThrowsAdvice {
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		System.out.println("Throw exception advice");
	}
}