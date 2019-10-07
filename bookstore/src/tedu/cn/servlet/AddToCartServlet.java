package tedu.cn.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tedu.cn.pojo.Cart;
import tedu.cn.pojo.User;
import tedu.cn.service.CartService;
import tedu.cn.service.impl.CartServiceImpl;

public class AddToCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User  user=(User)request.getSession().getAttribute("user");
		int count=Integer.parseInt(request.getParameter("count"));
		String produce=request.getParameter("product");
		Cart cart=new Cart();
		cart.setUid(user.getPhone());
		cart.setCount(count);
		cart.setBook(produce);
		CartService cs=new CartServiceImpl();
		try {
			cs.addCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		Writer outWriter=response.getWriter();
		outWriter.write("yes");
		outWriter.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
