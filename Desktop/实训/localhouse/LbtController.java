package com.lmmf.course.lbt.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lmmf.course.entity.LunBoTu;
import com.lmmf.course.entity.Student;
import com.lmmf.course.lbt.service.LunBoTuServiceImpl;
import com.lmmf.course.lbt.service.LunBoTuServiceImpl;
import com.lmmf.framework.Page;

/**
 * 閰嶇疆杞挱鍥炬帶鍒跺櫒绫伙紝瀹炵幇澧炪�佸垹銆佹敼銆佹煡鏂规硶锛�
 * 浣滆�咃細宀充紵鐜�
 * 鏃ユ湡锛�2016-11-16
 */
@Controller
@RequestMapping("shouyelunbotu")
public class LbtController {

	
	@Resource
	private LunBoTuServiceImpl  LbtServiceImpl;
	
	@RequestMapping("add")
	public String add(LunBoTu lunbotu){
		
		String pictureURL = lunbotu.getpictureURL();
		try {
			pictureURL = new String(pictureURL.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lunbotu.setpictureURL(pictureURL);
		String newsway = lunbotu.getnewsway();
		try {
			newsway = new String(newsway.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lunbotu.setnewsway(newsway);
		
		this.LbtServiceImpl.addLunBoTu(lunbotu);
		return "redirect:shouyelunbotu/list";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String toEdit(@RequestParam("id_SYLB") int id_SYLB,
			HttpServletRequest request){
		String searchParam = request.getParameter("searchParam");
		try {
			searchParam = new String(searchParam.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("searchParam",searchParam);
		LunBoTu lunbotu=this.LbtServiceImpl.getLunBoTu(id_SYLB);
		request.setAttribute("lunbotu", lunbotu);
		request.setAttribute("action", "edit");
		return "shouyelunbotu/form";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(LunBoTu lunbotu,HttpServletRequest request){
		String searchParam = request.getParameter("searchParam");
		try {
			searchParam = new String(searchParam.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("searchParam",searchParam);
		String pictureURL = lunbotu.getpictureURL();	
		try {
			pictureURL = new String(pictureURL.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lunbotu.setpictureURL(pictureURL);
		String newsway = lunbotu.getnewsway();	
		try {
			newsway = new String(newsway.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lunbotu.setnewsway(newsway);
		this.LbtServiceImpl.editLunBoTu(lunbotu);
		return "redirect:list";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam("id_SYLB") int id_SYLB,
			HttpServletRequest request){
		String searchParam = request.getParameter("searchParam");
		try {
			searchParam = new String(searchParam.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("searchParam",searchParam);
		this.LbtServiceImpl.dropLunBoTu(id_SYLB);
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(@RequestParam(name="pageNum", defaultValue="1") int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<LunBoTu> page;
		if(searchParam==null || "".equals(searchParam)){
			page=this.LbtServiceImpl.listLunBoTu(pageNum, 5, null);	
		}else{
			page=this.LbtServiceImpl.listLunBoTu(pageNum, 5, new Object[]{searchParam});
		}
		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "shouyelunbotu/list";
		
	}
}
