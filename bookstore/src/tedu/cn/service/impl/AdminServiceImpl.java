package tedu.cn.service.impl;


import tedu.cn.dao.AdminDao;
import tedu.cn.dao.UserDao;
import tedu.cn.dao.impl.AdminDaoImpl;
import tedu.cn.dao.impl.UserDaoImpl;
import tedu.cn.pojo.User;
import tedu.cn.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao dao=new AdminDaoImpl();
	public User Adminlogin(User user) throws Exception {
		// TODO Auto-generated method stub
		User u=dao.selectAdimin(user);
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
