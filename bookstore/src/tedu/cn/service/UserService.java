package tedu.cn.service;

import tedu.cn.pojo.User;

public interface UserService {
	/**
	 * 用户注册的业务
	 * @param user 前端传递的数据
	 * @throws Exception
	 */
	public void register(User user)throws Exception;
	/**
	 * 用户登陆的业务
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user)throws Exception;
	/**
	 * ajax验证用户
	 * @param uname
	 * @param role
	 * @return User
	 * @throws Exception
	 */
	public User ajaxfindUname(String uname,int role)throws Exception;
	public User ajaxfindEmail(String email,int role)throws Exception;
	public User ajaxfindPhone(String phone,int role)throws Exception;
	public void changePwd(String uname,String npwd)throws Exception;
	public User ajaxUpwd(String uname,String upwd,int role)throws Exception;
}
