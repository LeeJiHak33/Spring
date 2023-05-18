package kr.ac.kopo.gameshop.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.gameshop.model.Attach;

@Repository
public class AttachDaoImpl implements AttachDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public void add(Attach attach) {
		// TODO Auto-generated method stub
		sql.insert("attach.add",attach);
	}

	@Override
	public void deleteByGameId(int gameId) {
		// TODO Auto-generated method stub
		
		sql.delete("attach.delete_gameid", gameId);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(sql.delete("attach.delete",id)==1) {
			return true;
		}else {
			return false;
		}
		
	}

}
