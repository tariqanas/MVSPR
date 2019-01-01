package com.mvc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mvc.dao.ProduitRepository;
import com.mvc.entities.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository pr ;
	
	@RequestMapping(method=RequestMethod.GET ,value="/index")
	public String index(Model mod)
	{
		List<Produit> prods = pr.findAll();
		mod.addAttribute("lista",prods);
		return "produit";
	}
	
public ProduitController(){}



}
