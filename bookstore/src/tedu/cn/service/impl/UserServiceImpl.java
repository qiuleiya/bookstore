package tedu.cn.service.impl;

import tedu.cn.dao.UserDao;
import tedu.cn.dao.impl.UserDaoImpl;
import tedu.cn.pojo.User;
import tedu.cn.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao=new UserDaoImpl();
	public void register(User user) throws Exception {
		dao.insertUser(user);
	}
	public User login(User user) throws Exception {
		User u=dao.selectUser(user);
		return u;
	}
	public User ajaxfindUname(String uname, int role) throws Exception {
		User u=dao.ajaxSelectUname(uname, role);
		return u;
	}
	public User ajaxfindEmail(String email, int role) throws Exception {
		// TODO Auto-generated method stub
		User u=dao.ajaxSelectEmail(email, role);
		return u;
	}
	public User ajaxfindPhone(String phone, int role) throws Exception {
		// TODO Auto-generated method stub
		User u=dao.ajaxSelectPhone(phone, role);
		return u;
	}
	public User ajaxUpwd(String uname, String upwd,int role) throws Exception {
		// TODO Auto-generated method stub
		User u=dao.ajaxSelectPwd(uname, upwd,role);
		return u;
	}
	public void changePwd(String uname, String npwd) throws Exception {
		// TODO Auto-generated method stub
		dao.updateUpwd(uname, npwd);
	}

}
