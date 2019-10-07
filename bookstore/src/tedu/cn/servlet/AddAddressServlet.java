package tedu.cn.servlet;

import java.io.IOException;
import java.io.Writer;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import tedu.cn.pojo.Address;
import tedu.cn.pojo.User;
import tedu.cn.service.AddressService;
import tedu.cn.service.impl.AddressServiceImpl;

public class AddAddressServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ssssss");
		User user = (User)request.getSession().getAttribute("user");
		String receiver=request.getParameter("receiver");
		String address=request.getParameter("address");
		String rphone=request.getParameter("rphone");
		Address add=new Address();
		add.setAddress(address);
		add.setRphone(rphone);
		add.setReceiver(receiver);
		add.setUid(user.getPhone());
		AddressService as=new AddressServiceImpl();
		try {
			as.addAddress(add);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
