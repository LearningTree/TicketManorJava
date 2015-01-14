package com.ticketmanor.service;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Throwable {
		log("About to call " + ctx.getMethod().getName());
		Object o = ctx.proceed();	// The actual call!
		log("Returned from method " + ctx.getMethod().getName());
		return o;
	}
	
	void log(String mesg) {
		System.out.println(mesg);
	}
}
