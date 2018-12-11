package com.iu.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="idCheck")
	public String idCheck(String id, Model model) throws Exception {
		MemberDTO memberDTO = memberService.idCheck(id);
		//int result = 0 사용 불가,  1이면 사용가능
		int result = 0;
		if(memberDTO == null) {
			result = 1;
		}
		model.addAttribute("result", result);
		return "common/result";
	}
	
	@RequestMapping(value="join", method = RequestMethod.GET)
	public void join() throws Exception {}
	
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, RedirectAttributes rd) throws Exception {
		memberDTO.setGrade(9);
		int result = memberService.join(memberDTO);
		String path = "redirect:../";
		if(result < 1) {
			rd.addFlashAttribute("msg", "Fail");
			path = "redirect:./join";
		}
		return path;
	}

	@RequestMapping(value="login", method = RequestMethod.GET)
	public void login () throws Exception {}

	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login (MemberDTO memberDTO, RedirectAttributes rd, HttpSession session) throws Exception {
		memberDTO = memberService.login(memberDTO);
		String path = "";
		if(memberDTO != null) {
			path = "redirect:../";
			session.setAttribute("member", memberDTO);
		}else {
			path = "redirect:./login";
			rd.addFlashAttribute("msg", "Fail");
		}
		return path;
	}
	
	@RequestMapping(value="logout")
	private String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void update() throws Exception {}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd) throws Exception {
		MemberDTO sMemberDTO = (MemberDTO)session.getAttribute("member"); 
		memberDTO.setId(sMemberDTO.getId());
		int result = memberService.update(memberDTO);
		if(result > 0) {
			memberDTO.setGrade(sMemberDTO.getGrade());
			session.setAttribute("member", memberDTO);
		} else {
			rd.addFlashAttribute("msg", "Fail");
		}
		return "redirect:./myPage";
	}
	
	@RequestMapping(value="delete")
	public String delete(HttpSession session,RedirectAttributes rd) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberService.delete(memberDTO.getId());
		String message = "Delete Fail";
		if(result > 0) {
			message = "Delete Success";
			session.invalidate();
		}
		rd.addFlashAttribute("msg", message);
		return "redirect:../";
	}
	
	@RequestMapping(value="myPage")
	public void myPage() throws Exception {}
		
}
