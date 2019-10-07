package tedu.cn.service.impl;

import java.util.ArrayList;
import java.util.List;

import tedu.cn.dao.BookDao;
import tedu.cn.dao.CollectDao;
import tedu.cn.dao.impl.BookDaoImpl;
import tedu.cn.dao.impl.CollectDaoImpl;
import tedu.cn.pojo.Book;
import tedu.cn.pojo.Collect;
import tedu.cn.pojo.User;
import tedu.cn.service.CollectService;

public class CollectServiceImpl implements CollectService {
	CollectDao cd=new CollectDaoImpl();
	public List<Book> showUidBook(User user)throws Exception {
		// TODO Auto-generated method stub
		List<Book> list=new ArrayList<Book>();
		list=cd.selectUidBook(user);
		return list;
	}
	
	public Collect showByCollect(Collect collect) throws Exception {
		// TODO Auto-generated method stub
		Collect c=cd.selectByCollect(collect);
		return c;
	}

	public void ProduceIntoCollect(Collect collect) throws Exception {
		cd.insertCollect(collect);
	}
	public void ProductDeleteCollect(Collect collect) throws Exception {
		cd.deleteCollect(collect);
	}

}
