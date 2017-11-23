package com.yahoo.house.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class MyExceptionAdvice {
	
	@ExceptionHandler
	public  String toException(Model model){
		return "error/hint";
	}

}
