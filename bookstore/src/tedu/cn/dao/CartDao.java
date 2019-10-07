package tedu.cn.dao;

import java.util.List;

import tedu.cn.pojo.Cart;
import tedu.cn.pojo.CartAndBook;
import tedu.cn.pojo.User;

public interface CartDao {
	
	public void insertCart(Cart cart) throws Exception;
	public List<CartAndBook> selectUidCart(User user)throws Exception;
}
