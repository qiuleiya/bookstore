package tedu.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tedu.cn.pojo.Book;
import tedu.cn.pojo.User;
import tedu.cn.service.CollectService;
import tedu.cn.service.impl.CollectServiceImpl;

public class AllCollectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		List<Book> list=null;
		CollectService cs=new CollectServiceImpl();
		try {
			list=cs.showUidBook(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//将list集合存储在request作用域中进行转发
		request.setAttribute("books", list);
		request.getRequestDispatcher("/user/page/collect.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
