package com.iu.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTestCase;
import com.iu.s4.NoticeController;
import com.iu.util.Pager;

public class NoticeDAOTest extends AbstractTestCase {
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private NoticeController nc;
	
	
//	@Test
//	public void test() {
//		try {
//			int result = noticeDAO.delete(31);
//			assertEquals(1, result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	@Test
//	public void test() {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setTitle("한글 업데이트 시험");
//		noticeDTO.setContents("컨텐츠");
//		noticeDTO.setNum(31);
//		try {
//			int result = noticeDAO.update(noticeDTO);
//			assertEquals(1, result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void test() {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setTitle("ㅎㅇ ㅂㄱ ㅂㄱ");
//		noticeDTO.setWriter("빵꾸똥꾸");
//		noticeDTO.setContents("한글입력시험");
//		try {
//			int result = noticeDAO.insert(noticeDTO);
//			assertNotEquals(0, result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void test() {
//		try {
//			BoardDTO boardDTO = noticeDAO.select(10);
//			System.out.println(boardDTO.getTitle());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void test() {
//		Pager pager = new Pager();
//		pager.makeRow();
//		try {
//			int result = noticeDAO.totalCount(pager);
//			assertEquals(21, result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void test() {
//		Pager pager = new Pager();
//		pager.setKind("title");
//		pager.setSearch("DDDDDDD");
//		pager.makeRow();
//		try {
//			List<BoardDTO> ar = noticeDAO.list(pager);
//			
//			assertEquals(1, ar.size());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@AfterClass
//	public static void finish() {
//		System.out.println("Finish test");
//	}
//	
//	@BeforeClass
//	public static void start() {
//		System.out.println("Start Test");
//	}
//
//	@Before
//	public void before() {
//		System.out.println("Before Test");
//	}
//	
//	@After
//	public void after() {
//		System.out.println("After Test");
//	}
//	
//	@Test
//	public void deleteTest() {
//		try {
//			int result = noticeDAO.delete(3);
//			assertEquals(0, result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Delete Test");
//	}
//	
//	@Test
//	public void updateTest() {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(1);
//		boardDTO.setTitle("DDD");
//		boardDTO.setContents("WWWWWW");
//		try {
//			int result = noticeDAO.update(boardDTO);
//			assertEquals(1, result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Update Test");
//	}
//	
//	@Test
//	public void insertTest() {
//		BoardDTO boardDTO = new BoardDTO();
//		try {
//			int result = noticeDAO.insert(boardDTO);
//			assertEquals(1, result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Insert Test");
//	}
//	
	
}

