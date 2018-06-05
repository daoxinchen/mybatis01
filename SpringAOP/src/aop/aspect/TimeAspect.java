package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
	@Pointcut(value="execution(* aop..*.*(..))")
	public void pointcut() {
		
	}
	
	@Around(value="pointcut()")
	public Object time(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		
		Object result = joinPoint.proceed();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("执行对象："+joinPoint.getTarget().getClass());
		
		System.out.println("执行方法："+joinPoint.getSignature().getName());
		
		System.out.println("执行时间："+(endTime-startTime)+"毫秒数");
		
		return result;
	}
	
	
}
