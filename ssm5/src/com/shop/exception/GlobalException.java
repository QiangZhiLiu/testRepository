package com.shop.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常
 * @author newuser
 *
 */
public class GlobalException implements HandlerExceptionResolver{


	/*@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		String errorMsg = "对不起，程序员去泡妞了~~~";
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMsg", errorMsg);
		
		// 跳转界面
		mv.setViewName("error");
		
		
		return mv;
	}*/
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		String errorMsg = "对不起，程序员去泡妞了~~~";
	   // 需要判断我们自定义异常是不是 Exception 子类     MyException extends Exception
	   if(ex instanceof MyException)
	   {
		  errorMsg =  ((MyException) ex).getMsg();          
	   }
	   
	   
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMsg", errorMsg);
		
		// 跳转界面
		mv.setViewName("error");
		
		
		return mv;
	}

}
