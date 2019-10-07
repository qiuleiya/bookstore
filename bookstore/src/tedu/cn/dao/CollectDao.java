package tedu.cn.dao;

import java.util.List;

import tedu.cn.pojo.Book;
import tedu.cn.pojo.Collect;
import tedu.cn.pojo.User;

public interface CollectDao {
	/**
	 * �����û�uid��ѯ�ղ��鼮
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Book> selectUidBook(User user)throws Exception;
	
	/**�Ƿ��ղ�
	 * @param collect
	 * @return �ղ���
	 * @throws Exception
	 */
	public Collect selectByCollect(Collect collect)throws Exception;
	
	public void insertCollect(Collect collect)throws Exception;
	public void deleteCollect(Collect collect)throws Exception;
	
	
}
