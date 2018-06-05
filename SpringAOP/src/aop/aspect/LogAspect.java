package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component//日志切面
public class LogAspect {
	//在业务执行前来打印日志，前置通知
	public void before(JoinPoint joinPoint) {
		
		System.out.println("前置通知");
		
		//获取目标对象的类型
		Class targetClass = joinPoint.getTarget().getClass();
		System.out.println("目标对象："+targetClass);
		
		//获取目标方法
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("目标方法："+methodName);
		
		
	}
}
