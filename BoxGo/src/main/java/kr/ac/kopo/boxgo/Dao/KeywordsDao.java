package kr.ac.kopo.boxgo.Dao;

import java.util.List;

import kr.ac.kopo.boxgo.Model.Keywords;
import kr.ac.kopo.boxgo.pager.KeywordsPager;


public interface KeywordsDao {

	int total(KeywordsPager pager);

	List<Keywords> list(KeywordsPager pager);

	void add(Keywords item);

	void delete(Keywords item);

	Keywords item(Keywords item);

	void update(Keywords item);

}
