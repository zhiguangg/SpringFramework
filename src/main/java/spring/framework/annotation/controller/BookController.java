package spring.framework.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.framework.annotation.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Override
	public String toString() {
		return "BookController [bookService=" + bookService + "]";
	}
}
