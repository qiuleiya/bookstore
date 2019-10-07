package tedu.cn.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tedu.cn.pojo.User;
import tedu.cn.service.AdminService;
import tedu.cn.service.UserService;
import tedu.cn.service.impl.AdminServiceImpl;
import tedu.cn.service.impl.UserServiceImpl;

public class CheckAdminUpwdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		String uname=user.getUname();
		String upwd=request.getParameter("upwd");
		AdminService us=new AdminServiceImpl();
		User u=null;
		
		try {
			u=us.ajaxUpwd(uname, upwd,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�������������֤��Ϣ����ǰ��
		Writer out=response.getWriter();
		if(u==null){
			out.write("no");
		}else {
			out.write("yes");
		}
		//�ر���
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}