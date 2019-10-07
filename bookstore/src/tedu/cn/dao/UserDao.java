package tedu.cn.dao;

import tedu.cn.pojo.User;

public interface UserDao {
	/**
	 * 插入用户数据的方法
	 * @param user 前端用户传递过来的数据
	 * @throws Exception
	 */
	public void insertUser(User user)throws Exception;
	/**
	 * 查询用户的方法
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User selectUser(User user)throws Exception;
	/**
	 * 使用ajax异步查询用户名是否存在
	 * @param uname
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public User ajaxSelectUname(String uname,int role)throws Exception;
	public User ajaxSelectEmail(String email,int role)throws Exception;
	public User ajaxSelectPhone(String phone,int role)throws Exception;
	public User ajaxSelectPwd(String uname,String upwd,int role)throws Exception;
	public void updateUpwd(String uname,String npwd)throws Exception;
}
