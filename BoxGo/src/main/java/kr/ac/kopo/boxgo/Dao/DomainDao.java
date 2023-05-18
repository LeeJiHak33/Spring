package kr.ac.kopo.boxgo.Dao;

import java.util.List;

import kr.ac.kopo.boxgo.Model.Domain;
import kr.ac.kopo.boxgo.pager.Pager;

public interface DomainDao {

	int total(Pager pager);

	List<Domain> list(Pager pager);

	void add(Domain item);

	void delete(int id);

	Domain item(int id);

	void update(Domain item);

}
