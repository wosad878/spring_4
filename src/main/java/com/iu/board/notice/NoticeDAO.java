package com.iu.board.notice;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Inject
	private SqlSession session;
	private static final String NAMESPACE="noticeMapper.";
	
	public void test(Map<String, Object> map) throws Exception {
		session.insert(NAMESPACE+"insert", map);
	}
	
	
	public int getNum() throws Exception {
		return session.selectOne(NAMESPACE+"getNum");
	}
	
	@Override
	public int totalCount(Pager pager) throws Exception {
		return session.selectOne(NAMESPACE+"totalCount", pager);
	}
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return session.selectList(NAMESPACE + "selectList", pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		return session.selectOne(NAMESPACE+"selectOne", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return session.insert(NAMESPACE+"insert", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return session.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
	
		return session.delete(NAMESPACE+"delete", num);
	}

}
