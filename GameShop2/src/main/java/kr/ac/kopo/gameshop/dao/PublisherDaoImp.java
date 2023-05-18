package kr.ac.kopo.gameshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.gameshop.model.Publisher;
import kr.ac.kopo.gameshop.pager.Pager;

@Repository
public class PublisherDaoImp implements PublisherDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public int total(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectOne("publisher.total", pager);
	}

	@Override
	public List<Publisher> list(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectList("publisher.list", pager);
	}

	@Override
	public void add(Publisher item) {
		// TODO Auto-generated method stub
		sql.insert("publisher.add", item);
	}

	@Override
	public Publisher item(int id) {
		// TODO Auto-generated method stub
		return sql.selectOne("publisher.item", id);
	}

	@Override
	public void update(Publisher item) {
		// TODO Auto-generated method stub
		sql.update("publisher.update", item);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sql.delete("publisher.delete",id);
	}

}
