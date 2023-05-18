package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Customer;

public interface CustomerService {

	List<Customer> list();

	void add(Customer item);

	Customer item(int custid);

	void update(Customer item);

	void delete(int custid);

}
