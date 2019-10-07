package tedu.cn.dao;

import java.util.List;

import tedu.cn.pojo.Book;

public interface BookDao {
	/**
	 * 查询数据库中t_book表
	 * @return 将查询的结果添加到集合中
	 * @throws Exception
	 */
	public List<Book> selectBook()throws Exception;
	
	public Book selectDetailByIsbn(String isbn)throws Exception;
}
