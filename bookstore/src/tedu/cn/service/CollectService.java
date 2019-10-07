package tedu.cn.service;

import java.util.List;

import tedu.cn.pojo.Book;
import tedu.cn.pojo.Collect;
import tedu.cn.pojo.User;

public interface CollectService {
	public List<Book> showUidBook(User user)throws Exception;
	public Collect showByCollect(Collect collect)throws Exception;
	public void ProduceIntoCollect(Collect collect)throws Exception;
	public void ProductDeleteCollect(Collect collect)throws Exception;
	
}
