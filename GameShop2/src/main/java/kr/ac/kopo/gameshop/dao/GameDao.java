package kr.ac.kopo.gameshop.dao;

import java.util.List;

import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.pager.Pager;

public interface GameDao {

	List<Game> list(Pager pager);

	void add(Game item);

	void delete(int id, String memberId);

	void delete(int id); //초기화 할 때 사용
	
	Game item(int id);

	void update(Game item);

	int total(Pager pager);

	


}
