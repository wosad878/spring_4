package com.iu.board.notice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		return noticeDAO.list(pager);
	}
	
	public BoardDTO select(int num) throws Exception {
		return noticeDAO.select(num);
	}
	
	public int insert(BoardDTO boardDTO) throws Exception {
		return noticeDAO.insert(boardDTO);
	}
	
	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}
	
	public int delete(int num) throws Exception {
		return noticeDAO.delete(num);
	}
}
