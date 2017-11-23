package com.yahoo.house.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.yahoo.house.domain.House;
import com.yahoo.house.domain.User;
import com.yahoo.house.dto.PageBean;
import com.yahoo.house.dto.SearchHousePargram;
import com.yahoo.house.service.HouseService;
import com.yahoo.house.util.CommonUtil;

@Controller
@SessionAttributes({"searchParam"})
public class HouseController {
	
	@Autowired
	private HouseService houservice;
	
	
	@PostMapping("/searchHouse")
	public String searchHouse(SearchHousePargram searchParam,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size,
			Model model) {
		PageBean<House> pageBean=
		houservice.searchHouseswithParamByPage(searchParam, page, size);
		model.addAttribute("houseList", pageBean.getDataModel());
		model.addAttribute("currentPage", pageBean.getCurrentPage());
		model.addAttribute("totalPage", pageBean.getTotalPage());
		model.addAttribute("searchParam", searchParam);
		model.addAttribute("url", "searchHouse");
		return "index";
	}
	
	@GetMapping("/searchHouse")
	public String serachHouse(
			@SessionAttribute SearchHousePargram pargram,
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int size,
			Model  model) {
		PageBean<House> pageBean= houservice.searchHouseswithParamByPage(pargram, page, size);
		model.addAttribute("houseList", pageBean.getDataModel());
		model.addAttribute("currentPage", pageBean.getCurrentPage());
		model.addAttribute("totalPage", pageBean.getTotalPage());
		model.addAttribute("url", "searchHouse");
		return "index";
		
	}
	
	
	@PostMapping("/addHouse")
	public String addHouse(Model  model,House house,MultipartFile primaryPhoto,
			MultipartFile[] photo,HttpServletRequest req) 
	throws IOException{
		String viewName="pub";
		String originalFilename=primaryPhoto.getOriginalFilename();
		if(!primaryPhoto.isEmpty()) {
			String newFilename=CommonUtil.getUniqueFilename()
			+CommonUtil.getFilenameSuffix(originalFilename);
			String path=req.getServletContext().getRealPath("/images/upload");
			//保存上传文件到指定的文件中
			primaryPhoto.transferTo(new File(path+"/"+newFilename));
			house.setMainPhoto(newFilename);
			house.setPubDate(new Date());
			Integer userId=(Integer)req.getSession().getAttribute("userid");
			house.setUser(new User(userId));
			if(houservice.publishNewHouse(house)) {
				viewName="redirect:home";
			}else {
				model.addAttribute("hint","请求超时，请重新尝试！");
			}
		}
		return viewName;
	}
}
