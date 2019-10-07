package tedu.cn.dao;

import java.util.List;

import tedu.cn.pojo.Book;

public interface BookDao {
	/**
	 * ��ѯ���ݿ���t_book��
	 * @return ����ѯ�Ľ����ӵ�������
	 * @throws Exception
	 */
	public List<Book> selectBook()throws Exception;
	
	public Book selectDetailByIsbn(String isbn)throws Exception;
}
