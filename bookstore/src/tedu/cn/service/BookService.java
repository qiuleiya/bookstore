package tedu.cn.service;

import java.util.List;

import tedu.cn.pojo.Book;

public interface BookService {
	/**
	 * չʾͼ������ҳ��ҵ��
	 * @return
	 * @throws Exception
	 */
	public List<Book> showBook()throws Exception;
	
	public Book showDetailByIsbn(String isbn)throws Exception;
}
