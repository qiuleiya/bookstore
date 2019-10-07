package tedu.cn.service.impl;

import java.util.ArrayList;
import java.util.List;

import tedu.cn.dao.BookDao;
import tedu.cn.dao.impl.BookDaoImpl;
import tedu.cn.pojo.Book;
import tedu.cn.service.BookService;

public class BookServiceImpl implements BookService{
	BookDao bd=new BookDaoImpl();
	public List<Book> showBook() throws Exception {
		List<Book> list=new ArrayList<Book>();
		
		list=bd.selectBook();
		return list;
	}
	public Book showDetailByIsbn(String isbn) throws Exception {
		Book book=bd.selectDetailByIsbn(isbn);
		return book;
	}
	
	
}
