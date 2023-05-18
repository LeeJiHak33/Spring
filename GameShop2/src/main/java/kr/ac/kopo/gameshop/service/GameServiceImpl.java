package kr.ac.kopo.gameshop.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.gameshop.dao.AttachDao;
import kr.ac.kopo.gameshop.dao.GameDao;
import kr.ac.kopo.gameshop.model.Attach;
import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.pager.Pager;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameDao dao;
	
	@Autowired
	AttachDao attachDao;

	
	@Override
	public List<Game> list(Pager pager) {
		// TODO Auto-generated method stub
		int total=dao.total(pager);// dao한테 전체 개수 몇개야
		pager.setTotal(total);//받아온 전체 개수 pager에 넣기
		
		return dao.list(pager); // dao한테 list 내놔
	}

	@Override
	@Transactional
	public void add(Game item) {
		// TODO Auto-generated method stub
		dao.add(item);
		
		for(Attach  attach : item.getAttachs()) {
			attach.setGameId(item.getId());
			
			attachDao.add(attach);
		}
		
		
	}

	
	@Override
	@Transactional
	public void delete(int id, String memberId) {
		// TODO Auto-generated method stub
		attachDao.deleteByGameId(id);
		
		dao.delete(id,memberId);
	}

	@Override
	public Game item(int id) {
		// TODO Auto-generated method stub
		return dao.item(id);
	}

	@Transactional
	@Override
	public void update(Game item) {
		// TODO Auto-generated method stub
		dao.update(item);
		for(Attach  attach : item.getAttachs()) {
			attach.setGameId(item.getId());
			
			attachDao.add(attach);
		}
	}

	@Override
	public void dummy(String memberId) {
		// TODO Auto-generated method stub
		
		for(int count=1;count<100;count++) {
			Game item=new Game();
			item.setTitle("게임명 "+count);
			item.setPrice(count*1000);
			item.setPubDate(new Date());
			item.setMemberId(memberId);
			dao.add(item);
		}
	
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		List<Game> list;
		Pager pager=new Pager();
		pager.setPerPager(9999);//한페이지에 보여지는 리스트 개수를 9999해서 한번에 전체리스트를 보여줌
		do {
			list=dao.list(new Pager()); //전체리스트를 보여줌
			
				
			for(Game item :list) {//한줄 한줄 꺼내기
				dao.delete(item.getId());//한줄 삭제
			}
		}
		while(list.size()>0); ///list가 0일때 까지 반복
	}

	@Override
	public boolean deleteAttach(int id) {
		if(attachDao.delete(id)) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
