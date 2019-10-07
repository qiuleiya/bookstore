package tedu.cn.service.impl;


import java.util.ArrayList;
import java.util.List;

import tedu.cn.dao.CartDao;
import tedu.cn.dao.impl.CartDaoImpl;
import tedu.cn.pojo.Cart;
import tedu.cn.pojo.CartAndBook;
import tedu.cn.pojo.User;
import tedu.cn.service.CartService;

public class CartServiceImpl implements CartService {
     CartDao cd=new CartDaoImpl();

	public void addCart(Cart cart) throws Exception {
		// TODO Auto-generated method stub
		cd.insertCart(cart);
	}

	public List<CartAndBook> showUidCart(User user) throws Exception {
		// TODO Auto-generated method stub
		List<CartAndBook> list=new ArrayList<CartAndBook>();
		list=cd.selectUidCart(user);
		return list;
	}
     
}
