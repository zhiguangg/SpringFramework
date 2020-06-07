package spring.framework.annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void insertUser() {
		userDao.insert();
		//otherDao.other();xxx
		System.out.println("insert done...");
		int i=10/0;
	}
}
