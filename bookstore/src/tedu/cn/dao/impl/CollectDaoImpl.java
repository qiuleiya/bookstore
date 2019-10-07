package tedu.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tedu.cn.dao.CollectDao;
import tedu.cn.pojo.Book;
import tedu.cn.pojo.Collect;
import tedu.cn.pojo.User;
import tedu.cn.utiles.DBUtiles;

public class CollectDaoImpl implements CollectDao {

	public List<Book> selectUidBook(User user) throws Exception  {
			// TODO Auto-generated method stub
			List<Book> list=new ArrayList<Book>();
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try {
				conn=DBUtiles.getConnection();
				ps=conn.prepareStatement("select * from t_book where isbn in(select book from t_collect where uid=?)");
				ps.setString(1, user.getPhone());
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
			finally{
				DBUtiles.closeAll(conn, ps, rs);
			}
			return list;
		}

	public Collect selectByCollect(Collect collect) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Collect c=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from t_collect where uid=? and book=?");
			ps.setString(1, collect.getUid());
			ps.setString(2, collect.getBook());
			rs=ps.executeQuery();
			if(rs.next()){
				c=new Collect();
				c.setRid(rs.getInt("rid"));
				c.setBook(rs.getString("book"));
				c.setUid(rs.getString("uid"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}
	public void insertCollect(Collect collect) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("insert into t_collect(uid,book) values(?,?)");
			ps.setString(1, collect.getUid());
			ps.setString(2, collect.getBook());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtiles.closeAll(conn, ps, null);
		}
	}

	public void deleteCollect(Collect collect) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("delete from t_collect where uid=? and book=?");
			ps.setString(1, collect.getUid());
			ps.setString(2, collect.getBook());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtiles.closeAll(conn, ps, null);
		}		
	}



		
	
	}


