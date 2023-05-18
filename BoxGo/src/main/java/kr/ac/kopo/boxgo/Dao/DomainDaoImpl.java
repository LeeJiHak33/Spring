package kr.ac.kopo.boxgo.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.boxgo.Model.Domain;
import kr.ac.kopo.boxgo.pager.Pager;

@Repository
public class DomainDaoImpl implements DomainDao {
	@Autowired
	SqlSession sql;
	
	@Override
	public int total(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectOne("domain.total", pager);
	}

	@Override
	public List<Domain> list(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectList("domain.list",pager);
	}

	@Override
	public void add(Domain item) {
		// TODO Auto-generated method stub
		System.out.println("dfd"+item.getName());
		sql.insert("domain.add",item);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sql.delete("domain.delete", id);
	}

	@Override
	public Domain item(int id) {
		// TODO Auto-generated method stub
		return sql.selectOne("domain.item",id);
	}

	@Override
	public void update(Domain item) {
		// TODO Auto-generated method stub
		sql.update("domain.update",item);
	}

}
