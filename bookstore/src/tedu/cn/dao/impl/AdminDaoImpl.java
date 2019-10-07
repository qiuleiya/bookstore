package tedu.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tedu.cn.dao.AdminDao;
import tedu.cn.pojo.User;
import tedu.cn.utiles.DBUtiles;

public class AdminDaoImpl implements AdminDao {

	public User selectAdimin(User user) throws Exception {
		// TODO Auto-generated method stub
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
