package tedu.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tedu.cn.dao.UserDao;
import tedu.cn.pojo.User;
import tedu.cn.utiles.DBUtiles;

public class UserDaoImpl implements UserDao {

	public void insertUser(User user) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("insert into t_user(phone,uname,upwd,email,role) values(?,?,?,?,?)");
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getUpwd());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getRole());
			
			int i=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtiles.closeAll(conn, ps, null);
		}
	}

	public User selectUser(User user) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;;  
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from t_user where uname=? and upwd=? and role=?");
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setInt(3, user.getRole());
			
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setPhone(rs.getString("phone"));
				u.setEmail(rs.getString("email"));
				u.setRole(rs.getInt("role"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtiles.closeAll(conn, ps, rs);
		}
		return u;
	}

	public User ajaxSelectUname(String uname, int role) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from t_user where uname=? and role=?");
			ps.setString(1, uname);
			ps.setInt(2, role);
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setRole(rs.getInt("role"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtiles.closeAll(conn, ps, rs);
		}
		return u;
	}

	public User ajaxSelectEmail(String email, int role) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from t_user where email=? and role=?");
			ps.setString(1, email);
			ps.setInt(2, role);
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setRole(rs.getInt("role"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			DBUtiles.closeAll(conn, ps, rs);
		}
		return u;
	}

	public User ajaxSelectPhone(String phone, int role) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from t_user where phone=? and role=?");
			ps.setString(1, phone);
			ps.setInt(2, role);
			rs=ps.executeQuery();
			if(rs.next())
			{
				u=new User();
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setRole(rs.getInt("role"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
			}
	        
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally{
			DBUtiles.closeAll(conn, ps, rs);
		}
		return u;
	}

	

	public User ajaxSelectPwd(String uname, String upwd,int role) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("select * from t_user where uname=? and upwd=? and role=?");
			ps.setString(1, uname);
			ps.setString(2, upwd);
			ps.setInt(3, role);
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getString("phone"));
				u.setRole(rs.getInt("role"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtiles.closeAll(conn, ps, rs);
		}
		return u;
	}
	public void updateUpwd(String uname,String npwd) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("update t_user set upwd = ? where uname=?");
			ps.setString(1, npwd);
			ps.setString(2, uname);
			
				
				int i=ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUtiles.closeAll(conn, ps, null);
			}
		
	}

}
