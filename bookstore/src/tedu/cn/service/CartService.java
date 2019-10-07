package tedu.cn.service;

import java.util.List;

import tedu.cn.pojo.Cart;
import tedu.cn.pojo.CartAndBook;
import tedu.cn.pojo.User;

public interface CartService {
	public List<CartAndBook> showUidCart(User user)throws Exception;
	public void addCart(Cart cart)throws Exception;
}
