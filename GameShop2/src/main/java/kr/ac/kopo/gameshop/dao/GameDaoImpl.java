package kr.ac.kopo.gameshop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.pager.Pager;

@Repository
public class GameDaoImpl implements GameDao {
	
	@Autowired
	SqlSession sql;//mybatis
	
	@Override
	public List<Game> list(Pager pager) {
		
		return sql.selectList("game.list",pager); //game은 namespace 이름 id가 list인 쿼리를찾아라
	}

	@Override
	public void add(Game item) {
		// TODO Auto-generated method stub
		sql.insert("game.add",item);// item를 add해주세요
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sql.delete("game.delete",id);
	}

	@Override
	public Game item(int id) {
		// TODO Auto-generated method stub
		return sql.selectOne("game.item", id);
		
	}

	@Override
	public void update(Game item) {
		// TODO Auto-generated method stub
		sql.update("game.update",item);
	}

	@Override
	public int total(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectOne("game.total",pager);
	}

	@Override
	public void delete(int id, String memberId) {
		// TODO Auto-generated method stub
		HashMap<String, Object>map=new HashMap<>();
		map.put("id", id);
		map.put("memberId", memberId);
		
		sql.delete("game.delete_member",map);
	}

	

}
