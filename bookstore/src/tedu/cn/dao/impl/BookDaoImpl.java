package tedu.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tedu.cn.dao.BookDao;
import tedu.cn.pojo.Book;
import tedu.cn.utiles.DBUtiles;

public class BookDaoImpl implements BookDao {

	public List<Book> selectBook() throws Exception {
		List<Book> list=new ArrayList<Book>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from t_book");
			rs=ps.executeQuery();
			while(rs.next()){
				Book book=new Book();
				book.setAuthor(rs.getString("author"));
				book.setEdition(rs.getInt("edition"));
				book.setForm(rs.getString("form"));
				book.setFormat(rs.getString("format"));
				book.setIsbn(rs.getString("isbn"));
				book.setPackaging(rs.getString("packaging"));
				book.setPages(rs.getInt("pages"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getDouble("price"));
				book.setPublished(rs.getDate("published"));
				book.setTitle(rs.getString("title"));
				book.setWords(rs.getInt("words"));
				
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Book selectDetailByIsbn(String isbn) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Book book=null;
		
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from t_book  where isbn=?");
			ps.setString(1, isbn);
			rs=ps.executeQuery();
			if(rs.next()){
				book=new Book();
				book.setAuthor(rs.getString("author"));
				book.setEdition(rs.getInt("edition"));
				book.setForm(rs.getString("form"));
				book.setFormat(rs.getString("format"));
				book.setIsbn(rs.getString("isbn"));
				book.setPackaging(rs.getString("packaging"));
				book.setPages(rs.getInt("pages"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getDouble("price"));
				book.setPublished(rs.getDate("published"));
				book.setTitle(rs.getString("title"));
				book.setWords(rs.getInt("words"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}



}
