package tedu.cn.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tedu.cn.pojo.User;
import tedu.cn.service.UserService;
import tedu.cn.service.impl.UserServiceImpl;

public class CheckEmailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email=request.getParameter("email");
		UserService us=new UserServiceImpl();
		User user=null;
		try {
			user=us.ajaxfindEmail(email, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//定义输出流将验证信息带到前端
				Writer out=response.getWriter();
				if(user==null){
					out.write("no");
				}else {
					out.write("yes");
				}
				//关闭流
				out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
