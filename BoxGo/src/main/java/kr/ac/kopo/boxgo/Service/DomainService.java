package kr.ac.kopo.boxgo.Service;

import java.util.List;

import kr.ac.kopo.boxgo.Model.Domain;
import kr.ac.kopo.boxgo.pager.Pager;

public interface DomainService {

	List<Domain> list(Pager pager);

	void add(Domain item);

	void delete(int id);

	Domain item(int id);

	void update(Domain item);

}
