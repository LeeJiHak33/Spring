package kr.ac.kopo.boxgo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.boxgo.Dao.KeywordsDao;
import kr.ac.kopo.boxgo.Model.Keywords;
import kr.ac.kopo.boxgo.pager.KeywordsPager;
import kr.ac.kopo.boxgo.pager.Pager;

@Service
public class KeywordsServiceImpl implements KeywordsService {

	@Autowired
	KeywordsDao dao;
	
	@Override
	public List<Keywords> list(KeywordsPager pager) {
		// TODO Auto-generated method stub
		int total =dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public void add(Keywords item) {
		// TODO Auto-generated method stub
			dao.add(item);
	}

	@Override
	public void delete(Keywords item) {
		// TODO Auto-generated method stub
		dao.delete(item);
	}

	@Override
	public Keywords item(Keywords item) {
		// TODO Auto-generated method stub
		return dao.item(item);
	}

	@Override
	public void update(Keywords item) {
		// TODO Auto-generated method stub
		dao.update(item);
	}

	@Override
	public List<Keywords> list(int domainId) {
		// TODO Auto-generated method stub
		KeywordsPager pager=new KeywordsPager();
		pager.setDomainId(domainId);
		pager.setPerPage(0);
		return dao.list(pager);
	}

}
