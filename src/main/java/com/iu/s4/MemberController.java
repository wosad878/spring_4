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
	
	@RequestMapping(value="join", method = RequestMethod.GET)
	public void join() throws Exception {}
	
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, RedirectAttributes rd) throws Exception {
		int result = memberService.join(memberDTO);
		String path = "redirect:../";
		if(result < 1) {
			rd.addFlashAttribute("msg", "Fail");
			path = "redirect:./join";
		}
		return path;
	}

	@RequestMapping(value="idCheck", method = RequestMethod.GET)
	public String idCheck(String id, Model model) {
		model.addAttribute("id", id);
		return "/idCheck";
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
	private String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}
	

	@RequestMapping(value="myPage", method = RequestMethod.GET)
	public void myPage() throws Exception {}
	
	@RequestMapping(value="myPage", method = RequestMethod.POST)
	public String myPage(MemberDTO memberDTO, RedirectAttributes rd, HttpSession session) throws Exception {
		int result = memberService.update(memberDTO);
		if(result < 1) {
			rd.addFlashAttribute("msg","Fail");
			return "redirect:./myPage";
		}else {
			memberDTO =  memberService.login(memberDTO);
			session.invalidate();
			session.setAttribute("member", memberDTO);
			return "redirect:./myPage";
		}
	}

	@RequestMapping(value="delete")
	public String delete(String id, RedirectAttributes rd) throws Exception {
		int result = memberService.delete(id);
		if(result < 1) {
			rd.addFlashAttribute("msg", "Fail");
			return "redirect: /";
		}else {
			return "redirect: /";
		}
	}
}
