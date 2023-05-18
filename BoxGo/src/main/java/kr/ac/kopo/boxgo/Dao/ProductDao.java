package kr.ac.kopo.boxgo.Dao;

import java.util.List;

import kr.ac.kopo.boxgo.Model.Product;
import kr.ac.kopo.boxgo.pager.Pager;

public interface ProductDao {

	int total(Pager pager);

	List<Product> list(Pager pager);

	void add(Product item);

	void delete(int id);

	Product item(int id);

	void update(Product item);

}
