package com.iu.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Test
	public void test() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("test");
		noticeDTO.setWriter("test");
		noticeDTO.setContents("test");
		
		map.put("noticeDTO", noticeDTO);
		map.put("num", 0);
		noticeDAO.test(map);
		System.out.println(map.get("num"));
	}
}

