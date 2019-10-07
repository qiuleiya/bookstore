package tedu.cn.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tedu.cn.pojo.Collect;
import tedu.cn.pojo.User;
import tedu.cn.service.CollectService;
import tedu.cn.service.impl.CollectServiceImpl;

public class CollectYesOrNoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("aa");
		//获取ajax传递的数据
		String uid=request.getParameter("uid");
		String isbn=request.getParameter("isbn");
		Collect collect=new Collect();
		collect.setUid(uid);
		collect.setBook(isbn);
		CollectService cs=new CollectServiceImpl();
		try {
			Collect resulet=cs.showByCollect(collect);
			if(resulet!=null){
				cs.ProductDeleteCollect(collect);
				request.setAttribute("isCollect", "");
			}else {
				cs.ProduceIntoCollect(collect);
				request.setAttribute("isCollect", "2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Writer out=response.getWriter();
		out.write("yes");
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

