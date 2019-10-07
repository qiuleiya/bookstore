package tedu.cn.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import tedu.cn.pojo.User;
import tedu.cn.service.UserService;
import tedu.cn.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User u=new User();
		
		try {
			BeanUtils.populate(u, request.getParameterMap());
			u.setRole(0);
			UserService us=new UserServiceImpl();
			u=us.login(u);
			if(u!=null){
				//����ѯ�����û�����session��������
				request.getSession().setAttribute("user", u);
				//���û�������ת��������һ��servlet����������ҳչʾ��ҵ��
				request.getRequestDispatcher("/servlet/AllBookServlet").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/user/page/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
