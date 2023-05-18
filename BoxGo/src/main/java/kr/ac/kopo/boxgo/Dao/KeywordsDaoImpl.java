package kr.ac.kopo.boxgo.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.boxgo.Model.Keywords;
import kr.ac.kopo.boxgo.pager.KeywordsPager;

@Repository
public class KeywordsDaoImpl implements KeywordsDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public int total(KeywordsPager pager) {
		// TODO Auto-generated method stub
		return sql.selectOne("keywords.total", pager);
	}

	@Override
	public List<Keywords> list(KeywordsPager pager) {
		// TODO Auto-generated method stub
		return sql.selectList("keywords.list",pager);
	}

	@Override
	public void add(Keywords item) {
		// TODO Auto-generated method stub
		sql.insert("keywords.add",item);

	}

	@Override
	public void delete(Keywords item) {
		// TODO Auto-generated method stub
		sql.delete("keywords.delete",item);
	}

	@Override
	public Keywords item(Keywords item) {
		// TODO Auto-generated method stub
		return sql.selectOne("keywords.item", item);
	}

	@Override
	public void update(Keywords item) {
		// TODO Auto-generated method stub
		sql.update("keywords.update", item);
	}

}
