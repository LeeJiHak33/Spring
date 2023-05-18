package kr.ac.kopo.gameshop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.gameshop.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public Member login(Member member) {
		// TODO Auto-generated method stub
		return sql.selectOne("member.login",member);
	}

	@Override
	public void signup(Member item) {
		System.out.println(item.getId());
		sql.insert("member.signup",item);
	}

	@Override
	public int checkId(String id) {
		// TODO Auto-generated method stub
		return sql.selectOne("member.check_id",id);
	}

}
