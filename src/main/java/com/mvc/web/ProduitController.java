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
	public String index(Model mod,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size,@RequestParam(name="mc",defaultValue="")String mc )
	{
		
		Page<Produit> prods = pr.findbymc("%"+mc+"%",new PageRequest(page,size));
		mod.addAttribute("lista",prods.getContent());
		int nbrepages[] = new int[prods.getTotalPages()];
		mod.addAttribute("nbrepages",nbrepages);
		mod.addAttribute("size",size);
		mod.addAttribute("pageC",page);
		mod.addAttribute("mc",mc);
		return "produit";
	}
	/* heeeeeeeeere */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteornot(Long id,Model mod,@RequestParam(name="page",defaultValue="0")int page ,@RequestParam(name="size",defaultValue="5")int size)
	{
		mod.addAttribute("size",size);
		mod.addAttribute("pageC",page);
		pr.deleteById(id);
		return "produit";
	}
	
public ProduitController(){}



}
