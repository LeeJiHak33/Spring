package kr.ac.kopo.boxgo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.boxgo.Dao.DetailDao;
import kr.ac.kopo.boxgo.Dao.ProductDao;
import kr.ac.kopo.boxgo.Model.Detail;
import kr.ac.kopo.boxgo.Model.MobileDetail;
import kr.ac.kopo.boxgo.Model.Product;
import kr.ac.kopo.boxgo.pager.Pager;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Autowired
	DetailDao detailDao;
	
	@Override
	public List<Product> list(Pager pager) {
		// TODO Auto-generated method stub
		int total=dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Transactional
	@Override
	public void add(Product item) {
		// TODO Auto-generated method stub
		dao.add(item);
		
		Detail detail=item.getDetail();
		detail.setId(item.getId());
		
		detailDao.add(detail);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Product item(int id) {
		// TODO Auto-generated method stub
		return dao.item(id);
	}

	@Override
	public void update(Product item) {
		// TODO Auto-generated method stub
		dao.update(item);
	}

}
