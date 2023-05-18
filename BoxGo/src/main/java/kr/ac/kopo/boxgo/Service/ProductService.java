package kr.ac.kopo.boxgo.Service;

import java.util.List;

import kr.ac.kopo.boxgo.Model.Product;
import kr.ac.kopo.boxgo.pager.Pager;

public interface ProductService {

	List<Product> list(Pager pager);

	void add(Product item);

	void delete(int id);

	Product item(int id);

	void update(Product item);

}
