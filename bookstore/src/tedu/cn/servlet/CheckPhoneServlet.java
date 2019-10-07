package tedu.cn.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.Closeable;

import tedu.cn.pojo.User;
import tedu.cn.service.UserService;
import tedu.cn.service.impl.UserServiceImpl;

public class CheckPhoneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone=request.getParameter("phone");
		UserService us=new UserServiceImpl();
		User user=null;
		try {
			user=us.ajaxfindPhone(phone, 0);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//定义输出流将验证信息带到前端
		Writer out=response.getWriter();
		if(user==null){
			out.write("no");
		}
		else {
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
