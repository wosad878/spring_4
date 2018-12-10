package com.iu.s4;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.board.qna.QnaDTO;
import com.iu.board.qna.QnaService;
import com.iu.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public String qnaList(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("board", "qna").addAttribute("list", ar)
			.addAttribute("pager", pager);
		return "board/boardList";
	}
	@RequestMapping(value="qnaSelect")
	public String qnaSelect(int num, Model model, RedirectAttributes rd) throws Exception {
		BoardDTO boardDTO = qnaService.select(num);
		String path = "";
		if(boardDTO != null) {
			path = "board/boardSelect";
			model.addAttribute("boardDTO",boardDTO);
		} else {
			path="redirect:./qnaList";
			rd.addFlashAttribute("msg", "해당 글이 존재하지 않습니다");
		}
		model.addAttribute("board", "qna");
		return path;
	}
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result = qnaService.insert(boardDTO);
		if(result < 1) {
			rd.addFlashAttribute("msg", "Write Fail");
		}
		return "redirect:./qnaList";
	}
	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public String update(Model model, int num) throws Exception {
		BoardDTO boardDTO = qnaService.select(num);
		model.addAttribute("board", "qna").addAttribute("boardDTO", boardDTO);
		return "board/boardUpdate";
	}
	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result = qnaService.update(boardDTO);
		if(result < 1) {
			rd.addFlashAttribute("msg", "Update Fail");
		}

		return "redirect:./qnaSelect?num="+boardDTO.getNum();
	}
	@RequestMapping(value="qnaDelete", method=RequestMethod.POST)
	public String delete(int num, RedirectAttributes rd) throws Exception {
		int result = qnaService.delete(num);
		if(result < 1) {
			rd.addFlashAttribute("msg", "Delete Fail");
		}
		return "redirect:./qnaList";
	}
	@RequestMapping(value="qnaReply", method=RequestMethod.GET)
	public String reply(Model model, int num) {
		model.addAttribute("board", "qna").addAttribute("num", num);
		return "board/boardReply";
	}
	@RequestMapping(value="qnaReply", method=RequestMethod.POST)
	public String reply(QnaDTO qnaDTO, RedirectAttributes rd) throws Exception {
		int result = qnaService.reply(qnaDTO);
		return "redirect:./qnaSelect?num="+qnaDTO.getNum();
	}
}
