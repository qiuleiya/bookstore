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

public class CheckUnameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1��ȡajax�첽���������
		String uname=request.getParameter("uname");
		UserService us=new UserServiceImpl();
		User user=null;
		try {
			user=us.ajaxfindUname(uname, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�������������֤��Ϣ����ǰ��
		Writer out=response.getWriter();
		if(user==null){
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
