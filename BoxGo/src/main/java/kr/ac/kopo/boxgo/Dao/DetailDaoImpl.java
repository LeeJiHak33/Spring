package kr.ac.kopo.boxgo.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.boxgo.Model.Detail;
import kr.ac.kopo.boxgo.Model.MobileDetail;

@Repository
public class DetailDaoImpl implements DetailDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public void add(Detail detail) {
		// TODO Auto-generated method stub
		if(detail instanceof MobileDetail)
			sql.insert("detail.add_mobile", detail);
		else
			sql.insert("detail.add",detail);
	}

}
