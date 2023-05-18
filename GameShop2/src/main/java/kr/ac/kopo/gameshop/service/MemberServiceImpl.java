package kr.ac.kopo.gameshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.gameshop.dao.MemberDao;
import kr.ac.kopo.gameshop.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;
	
	@Override
	public boolean login(Member member) {
		// TODO Auto-generated method stub
		Member item=dao.login(member);
		if(item != null) { 
			
			member.setName(item.getName());
			member.setPasswd(null);
			member.setRegDate(item.getRegDate());
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public void signup(Member item) {
		System.out.println(item.getId());
		dao.signup(item);
	}

	@Override
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		if(dao.checkId(id)==0)
			return true;
		else
			return false;
	}

}
