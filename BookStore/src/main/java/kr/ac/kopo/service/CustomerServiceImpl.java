package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.CustomerDao;
import kr.ac.kopo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao dao;

	@Override
	public List<Customer> list() {
		return dao.list();
	}

	@Override
	public void add(Customer item) {
		dao.add(item);		
	}

	@Override
	public Customer item(int custid) {
		return dao.item(custid);
	}

	@Override
	public void update(Customer item) {
		dao.update(item);
	}

	@Override
	public void delete(int custid) {
		dao.delete(custid);
	}

}
