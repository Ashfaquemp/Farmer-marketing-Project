package com.kootam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kootam.entity.Address;
import com.kootam.entity.Vendor;
import com.kootam.entity.VendorCategory;
import com.kootam.repository.AddressRepository;
import com.kootam.repository.VendorCategoryRepository;
import com.kootam.repository.VendorRepository;

@Controller
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepo;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private VendorCategoryRepository vendorCateRepo;
	
	@GetMapping("/home_vendor")
	public String homeVender( Model m) {
		
		List<Vendor> list= vendorRepo.findAll();
		/*List<VendorCategory> listt= vendorCateRepo.findAll();
		List<Address> lisst= addressRepo.findAll();*/
		m.addAttribute("all_vendors",list);
		/*m.addAttribute("all_vendorCates",listt);
		m.addAttribute("all_address",lisst);*/
		
		
		return "homeVendor";
	}
	
	
	@GetMapping("/add_vendor")
	public String addVender() {
		
		return "addVendor";
	}
	
	
	@GetMapping("/edit_vendor")
	public String editVender() {
		
		return "editVendor";
	}
	
	@PostMapping("/save_vendor")
	public String saveVendor(@ModelAttribute Vendor vendor, Address address,VendorCategory vendorCate,HttpSession session) {
		
		vendorRepo.save(vendor);
		addressRepo.save(address);
		vendorCateRepo.save(vendorCate);
		session.setAttribute("msg", "Vendor Added Successfuly...");
		
		return "redirect:/add_vendor";
		
	}
	
	


}
