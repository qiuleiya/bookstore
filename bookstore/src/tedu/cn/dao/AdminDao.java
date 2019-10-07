package tedu.cn.dao;

import tedu.cn.pojo.User;

public interface AdminDao {
	public User selectAdimin(User user)throws Exception;
	public User ajaxSelectPwd(String uname,String upwd,int role)throws Exception;
	public void updateUpwd(String uname,String npwd)throws Exception;
}
