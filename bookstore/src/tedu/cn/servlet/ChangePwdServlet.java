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

public class ChangePwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		String uname=user.getUname();
		String npwd=request.getParameter("npwd");
		UserService us=new UserServiceImpl();
		try {
			us.changePwd(uname, npwd);
		} catch (Exception e) {
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
