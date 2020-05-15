package spring.framework.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.framework.annotation.service.BookService;

@Repository
public class BookDao {
	private String label = "1";
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "BookDao [label=" + label + "]";
	}

	
}
