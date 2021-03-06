package com.iu.s4;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeService;
import com.iu.util.FileSaver;
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList")
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = null;
		ar = noticeService.list(pager);
		model.addAttribute("list", ar).addAttribute("board", "notice").addAttribute("pager", pager);
		return "board/boardList";
	}
	
	@RequestMapping(value="noticeSelect")
	public String select(int num, Model model, RedirectAttributes rd) throws Exception {
		String path = noticeService.select(num, model, rd);
		return path;
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String write(BoardDTO boardDTO, HttpSession session, MultipartFile [] f1, RedirectAttributes rd) throws Exception {
		int result = noticeService.insert(boardDTO, f1, session);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String update(Model model, int num) throws Exception {
		BoardDTO boardDTO = noticeService.select(num);
		model.addAttribute("board", "notice").addAttribute(boardDTO);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes rs) throws Exception {
		int result = noticeService.update(boardDTO);
		int num = boardDTO.getNum();
		if(result < 1) {
			rs.addFlashAttribute("msg", "Update Fail");
		}else {
			rs.addFlashAttribute("msg", "Update Success");
		}
		return "redirect:./noticeSelect?num="+num;
	}
	
	@RequestMapping(value="noticeDelete", method=RequestMethod.POST)
	public String delete(int num, RedirectAttributes rs) throws Exception {
		int result = noticeService.delete(num);
		String path = "";
		if(result >0){
			rs.addFlashAttribute("msg", "Delete Success");
			path = "redirect:./noticeList";
		}else {
			rs.addFlashAttribute("msg", "Delete Fail");
			path = "redirect:./noticeSelect?num="+num;
		}
		return path;
	}
}














