package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ThrowAspect {

	@Pointcut(value="execution(* aop.service..*.*(..))")
	public void pointcut() {
		
	}
	
	@AfterThrowing(value="pointcut()",throwing="throwable")
	public void afterThrowing(JoinPoint joinPoint,Throwable throwable) {
		
		System.out.println("异常通知：");
		System.out.println("     异常通知类："+joinPoint.getTarget().getClass());
		System.out.println("     异常消息："+throwable.getMessage());
		
	}
}
