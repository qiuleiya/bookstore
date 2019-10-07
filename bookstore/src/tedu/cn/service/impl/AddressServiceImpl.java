package tedu.cn.service.impl;

import tedu.cn.dao.AddressDao;
import tedu.cn.dao.impl.AddressDaoImpl;
import tedu.cn.pojo.Address;
import tedu.cn.service.AddressService;

public class AddressServiceImpl implements AddressService {
    AddressDao dao=new AddressDaoImpl();
	public void addAddress(Address address) throws Exception {
		// TODO Auto-generated method stub
		dao.insertAddress(address);

	}

}
