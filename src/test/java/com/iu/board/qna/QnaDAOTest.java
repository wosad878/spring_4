package com.iu.board.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTestCase;
import com.iu.util.Pager;

public class QnaDAOTest extends AbstractTestCase {

	@Inject
	private QnaDAO qnaDAO;
	
//	@Test
	public void replyTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("rt1");
		qnaDTO.setWriter("rw1");
		qnaDTO.setContents("rc1");
		qnaDTO.setRef(3);
		qnaDTO.setStep(1);
		qnaDTO.setDepth(1);
		int result = qnaDAO.reply(qnaDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void deleteTest() {
		try {
			int result = qnaDAO.delete(2);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void insertTest() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			int result = qnaDAO.insert(boardDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	@Test
	public void updateTest() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			int result = qnaDAO.update(boardDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void selectTest() {
		BoardDTO boardDTO = new BoardDTO();
		try {
			boardDTO = qnaDAO.select(1);
			assertNotEquals(0, boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
	public void listTest() {
		Pager pager = new Pager();
		try {
			List<BoardDTO>ar = qnaDAO.list(pager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
