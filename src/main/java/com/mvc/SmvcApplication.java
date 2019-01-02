package com.mvc;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mvc.dao.ProduitRepository;
import com.mvc.entities.Produit;

@SpringBootApplication
public class SmvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SmvcApplication.class, args);
		
		ProduitRepository pr = ctx.getBean(ProduitRepository.class);
		pr.save(new Produit("Imprimante",124.0,2));
		pr.save(new Produit("Ordinateur",124.0,2));
		pr.save(new Produit("Smartphone",124.0,2));
		pr.save(new Produit("DD Externe",124.0,2));
		pr.save(new Produit("Imprimante",124.0,2));
		pr.save(new Produit("Ordinateur",124.0,2));
		pr.save(new Produit("Smartphone",124.0,2));
		pr.save(new Produit("DD Externe",124.0,2));
		pr.save(new Produit("Imprimante",124.0,2));
		pr.save(new Produit("Ordinateur",124.0,2));
		pr.save(new Produit("Smartphone",124.0,2));
		pr.save(new Produit("DD Externe",124.0,2));
		
		
		
		pr.findAll().forEach(p->System.out.println(p.getDesignation()));
		

		System.out.println("ok");
	}

}

