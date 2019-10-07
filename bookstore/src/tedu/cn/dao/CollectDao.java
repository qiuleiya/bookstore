package tedu.cn.dao;

import java.util.List;

import tedu.cn.pojo.Book;
import tedu.cn.pojo.Collect;
import tedu.cn.pojo.User;

public interface CollectDao {
	/**
	 * 根据用户uid查询收藏书籍
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Book> selectUidBook(User user)throws Exception;
	
	/**是否收藏
	 * @param collect
	 * @return 收藏书
	 * @throws Exception
	 */
	public Collect selectByCollect(Collect collect)throws Exception;
	
	public void insertCollect(Collect collect)throws Exception;
	public void deleteCollect(Collect collect)throws Exception;
	
	
}
