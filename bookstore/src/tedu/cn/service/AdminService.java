package tedu.cn.service;

import tedu.cn.pojo.User;

public interface AdminService {
	public User Adminlogin(User user) throws Exception;
	public void changePwd(String uname,String npwd)throws Exception;
	public User ajaxUpwd(String uname,String upwd,int role)throws Exception;

}
