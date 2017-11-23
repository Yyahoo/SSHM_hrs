package com.yahoo.house.controller;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yahoo.house.domain.City;
import com.yahoo.house.domain.District;
import com.yahoo.house.domain.House;
import com.yahoo.house.domain.HouseType;
import com.yahoo.house.domain.Province;
import com.yahoo.house.dto.PageBean;
import com.yahoo.house.service.HouseService;
import com.yahoo.house.service.LocationService;
import com.yahoo.house.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private LocationService locationService;
	@Autowired
	private HouseService houseService;
	/**
	 * 表示/就是首页
	 * @return
	 */
	@GetMapping({"/","/home"})
	public String toIndex(
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int size,
			Model model){
		PageBean<House> pageBean=houseService.listHousesByPage(page, size);
		model.addAttribute("houseList",pageBean.getDataModel());
		model.addAttribute("currentPage",pageBean.getCurrentPage());
		model.addAttribute("totalPage",pageBean.getTotalPage());
		model.addAttribute("url","home");
		return "home";
	}
	@GetMapping("/cities")
	@ResponseBody
	public List<City> getCities(Province province){
		return locationService.listAllCitiesByProvince(province);
	}
	@GetMapping("/districts")
	@ResponseBody
	public List<District> getDistricts(City city){
		return locationService.listAllDisTrictsByCity(city);
	}
	@GetMapping("/toLogin")
	public ModelAndView toLogin() {
		ModelAndView mav =new  ModelAndView();
		mav.setViewName("login");
		mav.addObject("hint", "欢迎来登录");
		return mav;
	}
	@GetMapping("/toReg")
	public String toReg() {
		return "register";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:home";
	}
	
	@GetMapping("/toPub")
	public String topub() {
	
	    return "pub";
	}
	

}
