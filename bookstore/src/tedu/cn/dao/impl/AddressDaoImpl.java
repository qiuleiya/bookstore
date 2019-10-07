package tedu.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;


import tedu.cn.dao.AddressDao;
import tedu.cn.pojo.Address;
import tedu.cn.pojo.User;
import tedu.cn.utiles.DBUtiles;

public class AddressDaoImpl implements AddressDao {

	public void insertAddress(Address address) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtiles.getConnection();
			ps=conn.prepareStatement("insert into t_address(uid,address,added,receiver,rphone) values(?,?,NOW(),?,?)");
			ps.setString(1, address.getUid());
			ps.setString(2, address.getAddress());
			
			ps.setString(3, address.getReceiver());
			ps.setString(4, address.getRphone());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtiles.closeAll(conn, ps, null);
		}
		
	}

}
