package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.CategoryDAO;
import com.poly.dao.ProductDAO;
import com.poly.dao.ProductsDetailDAO;
import com.poly.dao.UsersDAO;
import com.poly.entity.Categories;
import com.poly.entity.Products;
import com.poly.entity.ProductsDetails;
import com.poly.entity.Users;
import com.poly.service.SessionService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PageController {
	@Autowired
	SessionService session;

	@Autowired
	ProductDAO proDao;

	@Autowired
	UsersDAO userDao;

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}


	@RequestMapping("/ttt")
	public String homePag() {
		return "adminn";
	}
	@RequestMapping("/index")
	public String trangChu() {
		return "index";
	}

	@RequestMapping("/sanpham")
	public String sanPham() {
		return "sanpham";
	}

	@RequestMapping("/lienHe")
	public String lienHe() {
		return "lienHe";
	}

	@RequestMapping("/gioiThieu")
	public String gioiThieu() {
		return "gioiThieu";
	}
	
	@RequestMapping("/chiTiet")
	public String chiTiet() {
		return "chiTiet";
	}
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	@GetMapping("/thongtin")
	public String userDetail(Model model , @ModelAttribute("us") Users us) {
		Users use = session.get("user");
		if(use != null) {
			model.addAttribute("us", use);
		}else {
			return "DangNhap";
		}
		  
		  return "thongtin";
		}
	

	@GetMapping("/product/page")
	public String page(Model model, @RequestParam("product") Optional<Integer> product) {
		
		return "sanpham";
	}

//
//	@GetMapping("/product/page")
//	public String page(Model model, @RequestParam("product") Optional<Integer> product) {
//		Pageable page = PageRequest.of(product.orElse(0), 9);
//		model.addAttribute("page", proDao.findAll(page));
//		return "sanpham";
//	}
//    
//  
	@RequestMapping("/product/page")
	public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("product") Optional<Integer> product ,HttpServletRequest request) {
		String kwords = kw.orElse(session.get("keywords"));
		session.set("keywords", kwords);
		Pageable pageable = PageRequest.of(product.orElse(0), 5);
		Page<Products> page = proDao.findByKeywords("%" + kwords + "%", pageable);
		model.addAttribute("page", page);
		return "sanpham";
	}
	
	@RequestMapping("/product/sortnamelow")
	public String sortnamelow(Model model,@RequestParam("product") Optional<Integer> product,HttpServletRequest request) {
		Pageable pageable = PageRequest.of(product.orElse(0), 9);
		Page<Products> page = proDao.findBySortNameLow(pageable);
		model.addAttribute("page", page);
		return "sanpham";
	}
	
	@RequestMapping("/product/sortnamehigh")
	public String sortnamehigh(Model model,@RequestParam("product") Optional<Integer> product,HttpServletRequest request) {
		Pageable pageable = PageRequest.of(product.orElse(0), 9);
		Page<Products> page = proDao.findBySortNameHigh(pageable);
		String currentURL = request.getRequestURL().toString();
		 model.addAttribute("map",currentURL);
		model.addAttribute("page", page);
		return "sanpham";
	}
	
	@RequestMapping("/product/sortpricelow")
	public String sortpricelow(Model model,@RequestParam("product") Optional<Integer> product,HttpServletRequest request) {
		Pageable pageable = PageRequest.of(product.orElse(0), 9);
		Page<Products> page = proDao.findBySortPriceLow(pageable);
		String currentURL = request.getRequestURL().toString();
		 model.addAttribute("map",currentURL);
		model.addAttribute("page", page);
		return "sanpham";
	}
	
	@RequestMapping("/product/sortpricehigh")
	public String sortpricehigh(Model model,@RequestParam("product") Optional<Integer> product,HttpServletRequest request) {
		Pageable pageable = PageRequest.of(product.orElse(0), 9);
		Page<Products> page = proDao.findBySortPriceHigh(pageable);
		model.addAttribute("page", page);
		String currentURL = request.getRequestURL().toString();
		 model.addAttribute("map",currentURL);
		return "sanpham";
	}
	
	@RequestMapping("/product/sortprice57")
	public String sortprice57(Model model,@RequestParam("product") Optional<Integer> product,HttpServletRequest request) {
		Pageable pageable = PageRequest.of(product.orElse(0), 9);
		Page<Products> page = proDao.findBySortPriceBetween57(pageable);
		String currentURL = request.getRequestURL().toString();
		 model.addAttribute("map",currentURL);
		model.addAttribute("page", page);
		return "sanpham";
	}
	
	@RequestMapping("/product/sortprice710")
	public String sortprice710(Model model,@RequestParam("product") Optional<Integer> product,HttpServletRequest request) {
		Pageable pageable = PageRequest.of(product.orElse(0), 9);
		Page<Products> page = proDao.findBySortPriceBetween710(pageable);
		String currentURL = request.getRequestURL().toString();
		 model.addAttribute("map",currentURL);
		model.addAttribute("page", page);
		return "sanpham";
	}
	
	@RequestMapping("/product/sortprice1050")
	public String sortprice1050(Model model,@RequestParam("product") Optional<Integer> product,HttpServletRequest request) {
		Pageable pageable = PageRequest.of(product.orElse(0), 9);
		Page<Products> page = proDao.findBySortPrice1050(pageable);
		String currentURL = request.getRequestURL().toString();
		 model.addAttribute("map",currentURL);
		model.addAttribute("page", page);
		return "sanpham";
	}
	
	@RequestMapping("/product/sortpricehigh50")
	public String sortpricehigh50(Model model,@RequestParam("product") Optional<Integer> product,HttpServletRequest request) {
		Pageable pageable = PageRequest.of(product.orElse(0), 9);
		Page<Products> page = proDao.findBySortPriceHigh50(pageable);
		String currentURL = request.getRequestURL().toString();
		 model.addAttribute("map",currentURL);
		model.addAttribute("page", page);
		return "sanpham";
	}
	
	
	@GetMapping("/detail")
	public String productDetailPage(@RequestParam("id") String product_id, @RequestParam("id") String category_id, Model model) {
	  // Lấy thông tin sản phẩm từ CSDL dựa trên productId
	  Products product = proDao.findProductById(product_id);
	  model.addAttribute("product", product);
	  model.addAttribute("PDD", product.getProductsDetails());
	  return "chiTiet";
	}


	
	@GetMapping("/GioHang")
	public String gioHang(Model model) {
		Users User = session.get("user");
		
		if(User==null) {
			return "redirect:/DangNhap";
		}else if(!User.getActivated()) {
			return "XacThuc";
		}else {
			model.addAttribute("Orders",session.get("Order"));
		return "GioHang";
		} 
	}

}
