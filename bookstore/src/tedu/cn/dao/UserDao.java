package tedu.cn.dao;

import tedu.cn.pojo.User;

public interface UserDao {
	/**
	 * �����û����ݵķ���
	 * @param user ǰ���û����ݹ���������
	 * @throws Exception
	 */
	public void insertUser(User user)throws Exception;
	/**
	 * ��ѯ�û��ķ���
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User selectUser(User user)throws Exception;
	/**
	 * ʹ��ajax�첽��ѯ�û����Ƿ����
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
