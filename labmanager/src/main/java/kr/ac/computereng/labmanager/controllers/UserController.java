package kr.ac.computereng.labmanager.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.ac.computereng.labmanager.common.datatype.UserDatatype;
import kr.ac.computereng.labmanager.common.user.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	/**
	 * 회원가입폼에 user modelattribute 만들기
	 * @return
	 */
	@RequestMapping(path="/joinform", method=RequestMethod.GET)
	public ModelAndView joinform() {
		return new ModelAndView("joinform", "user", new UserDatatype());
	}
	
	/**
	 * user 정보 보내기
	 * @param user
	 * @return 메인페이지
	 */
	@RequestMapping(path="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("user") UserDatatype user) {
		try {
			this.userService.joinUser(user);
		} catch (Exception e) {
			// TODO Exception handling. for example move to error message html page.
			e.printStackTrace();
		}
		return "redirect: /labmanager/main/hello";
	}
	
	/**
	 * 로그인폼에 user modelattribute 만들기
	 * @return
	 */
	@RequestMapping(path="/loginform", method=RequestMethod.GET)
	public ModelAndView loginform() {
		return new ModelAndView("loginform", "user", new UserDatatype());
	}
	
	/**
	 * 로그인하기
	 * @param session
	 * @param user
	 * @return
	 */
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpSession session, @ModelAttribute("user") UserDatatype user) {
		ModelAndView mv = new ModelAndView();
		RedirectView rv = new RedirectView("/labmanager/main/hello");
		rv.setExposeModelAttributes(false);
		mv.setView(rv);
		try {
			UserDatatype member = this.userService.login(user.getId(), user.getPassword());
			if(member == null) {
				mv.setViewName("loginform");
			}
			else {
				session.setAttribute("user", member);
			}
		} catch (Exception e) {
			// TODO Exception handling. for example move to error message html page.
		}
		return mv;
	}
	
	@RequestMapping(path="/modifyform", method=RequestMethod.GET)
	public ModelAndView modifyform(HttpSession session) {
		UserDatatype user = (UserDatatype)session.getAttribute("user");
		//mv.setViewName("modifyform");
		//return mv;
		
		return new ModelAndView("modifyform", "user", user);
	}
	
	@RequestMapping(path="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("user") UserDatatype user) {
		try {
			this.userService.updateUser(user);
		} catch (Exception e) {
			// TODO Exception handling. for example move to error message html page.
		}
		return "redirect: /labmanager/main/hello";
	}
	
	@RequestMapping(path="/withdraw", method=RequestMethod.GET)
	public String withdraw(HttpSession session) {
		try {
			UserDatatype user = (UserDatatype)session.getAttribute("user");
			this.userService.withdraw(user.getId());
			session.invalidate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "withdraw";
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		try {
			session.invalidate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "logout";
	}
	
	@RequestMapping(path="/selectAll", method=RequestMethod.GET)
	public ModelAndView selectAll() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("selectAll");
		try {
			mv.addObject("userList", this.userService.search());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path="/selectOne", method=RequestMethod.GET)
	public ModelAndView selectOne(String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/selectOne");
		try {
			UserDatatype user = this.userService.searchOne(id);
			mv.addObject("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	/*
	@RequestMapping(path="/delete", method=RequestMethod.GET)
	public String delete(String id) {
		try {
			this.userService.withdraw(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: /labmanager/user/selectAll";
	}
	*/
	
	
	//----------------------------or--------------------------

	
	
}
