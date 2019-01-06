package com.mvc.dao;
import com.mvc.entities.Produit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit,Long>
{
	@Query("select a from Produit a where a.designation like :x ")
	public Page<Produit> findbymc(@Param("x")String designation,Pageable pae);

}
