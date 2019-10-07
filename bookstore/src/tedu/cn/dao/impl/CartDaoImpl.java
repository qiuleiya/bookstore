package tedu.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tedu.cn.dao.CartDao;
import tedu.cn.pojo.Book;
import tedu.cn.pojo.Cart;
import tedu.cn.pojo.CartAndBook;
import tedu.cn.pojo.User;
import tedu.cn.utiles.DBUtiles;

public class CartDaoImpl implements CartDao {

	public void insertCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("inser into t_cart(uid,book,count) values(?,?,?)");
			ps.setString(1,cart.getUid());
			ps.setString(2, cart.getBook());
			ps.setInt(3, cart.getCount());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			DBUtiles.closeAll(conn, ps, null);
		}
		
	}

	public List<CartAndBook> selectUidCart(User user) throws Exception {
		// TODO Auto-generated method stub
		List<CartAndBook> list=new ArrayList<CartAndBook>();
		Connection conn=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		try {
			conn=DBUtiles.getConnection();
			ps1=conn.prepareStatement("select * from t_book where isbn in(select book from t_cart where uid=?)");
			ps1.setString(1, user.getPhone());
			rs1=ps1.executeQuery();
			ps2=conn.prepareStatement("select * from t_cart where uid=?");
			ps2.setString(1, user.getPhone());
			rs2=ps2.executeQuery();
			while(rs1.next() && rs2.next()){
				CartAndBook cartAndBook=new CartAndBook();
				Book book=new Book();
				Cart cart=new Cart();
				book.setAuthor(rs1.getString("author"));
				book.setEdition(rs1.getInt("edition"));
				book.setForm(rs1.getString("form"));
				book.setFormat(rs1.getString("format"));
				book.setIsbn(rs1.getString("isbn"));
				book.setPackaging(rs1.getString("packaging"));
				book.setPages(rs1.getInt("pages"));
				book.setPress(rs1.getString("press"));
				book.setPrice(rs1.getDouble("price"));
				book.setPublished(rs1.getDate("published"));
				book.setTitle(rs1.getString("title"));
				book.setWords(rs1.getInt("words"));
				cart.setBook(rs2.getString("book"));
				cart.setCount(rs2.getInt("count"));
				cart.setRid(rs2.getInt("rid"));
				cart.setUid(rs2.getString("uid"));
				cartAndBook.setBook(book);
				cartAndBook.setCart(cart);
				list.add(cartAndBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUtiles.closeAll(conn, ps1, rs1);
			DBUtiles.closeAll(conn, ps2, rs2);
		}
		return list;
	}

}
