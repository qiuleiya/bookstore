package tedu.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tedu.cn.pojo.Book;
import tedu.cn.pojo.Collect;
import tedu.cn.pojo.User;
import tedu.cn.service.BookService;
import tedu.cn.service.CollectService;
import tedu.cn.service.impl.BookServiceImpl;
import tedu.cn.service.impl.CollectServiceImpl;

public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println(request.getParameter("isbn"));
		String isbn=request.getParameter("isbn");
		BookService bs=new BookServiceImpl();
		try {
			Book book=bs.showDetailByIsbn(isbn);
			request.setAttribute("book", book);
			
			User user=(User) request.getSession().getAttribute("user");
			String product=request.getParameter("isbn");
			Collect collect=new Collect();
			collect.setBook(product);
			collect.setUid(user.getPhone());
			CollectService cs=new CollectServiceImpl();
			collect=cs.showByCollect(collect);
			if(collect!=null){
				request.setAttribute("isCollect", "2");
			}else {
				request.setAttribute("isCollect", "");
			}
			
			request.getRequestDispatcher("/user/page/detail.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
