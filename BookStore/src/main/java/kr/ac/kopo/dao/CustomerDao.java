package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.model.Customer;

public interface CustomerDao {

	List<Customer> list();

	void add(Customer item);

	Customer item(int custid);

	void update(Customer item);

	void delete(int custid);

}
