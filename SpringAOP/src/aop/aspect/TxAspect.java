package aop.aspect;

import org.springframework.stereotype.Component;

@Component
public class TxAspect {
	//通知
	public String afterReturning(String msg) {
		System.out.println("后置通知");
		System.out.println("目标对象返回结果："+msg);
		return msg;
	}
}
