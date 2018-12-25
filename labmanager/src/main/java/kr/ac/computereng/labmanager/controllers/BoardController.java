package kr.ac.computereng.labmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.computereng.labmanager.common.board.IBoardService;
import kr.ac.computereng.labmanager.common.datatype.BoardDatatype;
import kr.ac.computereng.labmanager.common.datatype.Criteria;
import kr.ac.computereng.labmanager.common.datatype.PageMaker;
import kr.ac.computereng.labmanager.common.datatype.SearchCriteria;

@Controller
//@RequestMapping("labmanager/board/*")
public class BoardController {
	
	@Autowired //의존성 주입
	private IBoardService boardService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET(BoardDatatype board,Model model) throws Exception{
		model.addAttribute("board", new BoardDatatype()); //MODEL 은 데이터를 뷰에 보내는 박스
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPOST(BoardDatatype board,RedirectAttributes rttr) throws Exception{
		boardService.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS"); //일회용 박스
		return "redirect:/board/listPage"; //리턴 타입은 내가 보낼 뷰
	}
	
	@RequestMapping(value="/listPage",method=RequestMethod.GET) //페이징
	public void listPage(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception{
		model.addAttribute("list",boardService.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCountCriteria(cri));
		model.addAttribute("pageMaker",pageMaker);
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception{
		model.addAttribute(boardService.read(bno));
	}
	
	@RequestMapping(value="/removePage",method=RequestMethod.POST)
	public String removePage(@RequestParam("bno") int bno,SearchCriteria cri,RedirectAttributes rttr) throws Exception{
		boardService.remove(bno);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.GET)
	public void modifyPageGET(@RequestParam("bno") int bno,@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception{
		model.addAttribute(boardService.read(bno));
	}
	
	@RequestMapping(value="/modifyPage",method=RequestMethod.POST)
	public String modifyPagePOST(BoardDatatype board,SearchCriteria cri,RedirectAttributes rttr) throws Exception{
		boardService.modify(board);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		rttr.addAttribute("searchType",cri.getSearchType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listPage";
	}
}
