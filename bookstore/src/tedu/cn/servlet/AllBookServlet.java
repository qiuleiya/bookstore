package tedu.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tedu.cn.pojo.Book;
import tedu.cn.service.BookService;
import tedu.cn.service.impl.BookServiceImpl;

public class AllBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> list=null;
		BookService bs=new BookServiceImpl();
		try {
			list=bs.showBook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//将list集合存储在request作用域中进行转发
		request.setAttribute("books", list);
		request.getRequestDispatcher("/user/page/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
