package com.mvc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.dao.ProduitRepository;
import com.mvc.entities.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository pr ;
	
	@RequestMapping(method=RequestMethod.GET ,value="/index")
	public String index(Model mod,@RequestParam(name="page")int page,@RequestParam(name="size")int size)
	{
		Page<Produit> prods = pr.findAll(new PageRequest(page,size));
		mod.addAttribute("lista",prods.getContent());
		int nbrepages[] = new int[prods.getTotalPages()];
		mod.addAttribute("nbrepages",nbrepages);
		return "produit";
	}
	
public ProduitController(){}



}
