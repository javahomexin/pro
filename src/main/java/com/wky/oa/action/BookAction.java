package com.wky.oa.action;

import com.wky.oa.base.BaseAction;
import com.wky.oa.domain.Book;
import org.springframework.stereotype.Controller;


@Controller
public class BookAction extends BaseAction<Book> {
	public String execute() throws Exception {
		System.out.println(model);
		
		bookService.save(model);
		return NONE;
	}
}
