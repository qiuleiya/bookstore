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

public class CheckUpwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		String uname=user.getUname();
		String upwd=request.getParameter("upwd");
		UserService us=new UserServiceImpl();
		User u=null;
		
		try {
			u=us.ajaxUpwd(uname, upwd,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//定义输出流将验证信息带到前端
		Writer out=response.getWriter();
		if(u==null){
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
