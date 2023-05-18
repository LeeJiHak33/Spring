package kr.ac.kopo.boxgo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.boxgo.Dao.DomainDao;
import kr.ac.kopo.boxgo.Model.Domain;
import kr.ac.kopo.boxgo.pager.Pager;

@Service
public class DomainServiceImpl implements DomainService {

	@Autowired
	DomainDao dao;
	
	@Override
	public List<Domain> list(Pager pager) {
		// TODO Auto-generated method stub
		
		int total=dao.total(pager);
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Domain item) {
		dao.add(item);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Domain item(int id) {
		// TODO Auto-generated method stub
		return dao.item(id);
	}

	@Override
	public void update(Domain item) {
		// TODO Auto-generated method stub
		dao.update(item);
	}

}
