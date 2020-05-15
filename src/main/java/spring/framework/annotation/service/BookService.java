package spring.framework.annotation.service;

import org.springframework.stereotype.Service;

import spring.framework.annotation.dao.BookDao;
import javax.annotation.Resource;
import javax.inject.Inject;
@Service
public class BookService {
	
	//@Qualifier("bookDao")
	//@Autowired(required=false)
	//@Resource(name="bookDao2")
	@Inject
	private BookDao bookDao;
	
	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
}
