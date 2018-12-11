package com.iu.board.notice;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileDAO fileDAO;
	
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		return noticeDAO.list(pager);
	}
	
	public BoardDTO select(int num) throws Exception {
		return noticeDAO.select(num);
	}
	@Override
	public int insert(BoardDTO boardDTO) {
		return 0;
	}
	
	public int insert(BoardDTO boardDTO, MultipartFile [] f1, HttpSession session) throws Exception {
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/notice");
		int num = noticeDAO.getNum();
		boardDTO.setNum(num);
		int result = noticeDAO.insert(boardDTO);
		if(result < 1) {
			throw new Exception();
		}
		for(MultipartFile mFile: f1) {
			if(mFile.isEmpty()) {
				continue;
			}
			FileDTO fileDTO = new FileDTO();
			fileDTO.setOname(mFile.getOriginalFilename());
			fileDTO.setFname(fs.saveFile3(realPath, mFile));
			fileDTO.setKind("n");
			fileDTO.setNum(num);
			result = fileDAO.insert(fileDTO);
			if(result < 1) {
				throw new Exception();
			}
		}
		return result;
	}
	
	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}
	
	public int delete(int num) throws Exception {
		return noticeDAO.delete(num);
	}
}
