package com.iu.board.notice;

import java.util.List;

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
	private String namespace="noticeMapper.";
	
	@Override
	public int totalCount(Pager pager) throws Exception {
		return session.selectOne(namespace+"totalCount", pager);
	}
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return session.selectList(namespace + "selectList", pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		return session.selectOne(namespace+"selectOne", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return session.insert(namespace+"insert", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return session.update(namespace+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
	
		return session.delete(namespace+"delete", num);
	}

}
