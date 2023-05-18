package kr.ac.kopo.boxgo.Service;

import java.util.List;

import kr.ac.kopo.boxgo.Model.Keywords;
import kr.ac.kopo.boxgo.pager.KeywordsPager;
import kr.ac.kopo.boxgo.pager.Pager;

public interface KeywordsService {

	List<Keywords> list(KeywordsPager pager);

	void add(Keywords item);

	void delete(Keywords item);

	Keywords item(Keywords item);

	void update(Keywords item);

	List<Keywords> list(int domainId);

}
