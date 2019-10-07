package tedu.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tedu.cn.pojo.Book;
import tedu.cn.pojo.CartAndBook;
import tedu.cn.pojo.User;
import tedu.cn.service.CartService;
import tedu.cn.service.CollectService;
import tedu.cn.service.impl.CartServiceImpl;
import tedu.cn.service.impl.CollectServiceImpl;

public class AllCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		List<CartAndBook> list=null;
		CartService cs=new CartServiceImpl();
		try {
			list=cs.showUidCart(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//将list集合存储在request作用域中进行转发
		request.setAttribute("cartAndBooks", list);
		request.getRequestDispatcher("/user/page/cart.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
