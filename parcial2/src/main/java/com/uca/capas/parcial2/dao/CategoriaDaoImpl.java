package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.Categoria;


@Repository
public class CategoriaDaoImpl implements CategoriaDao{

	@PersistenceContext(name = "capas")
	EntityManager entityManager;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		
		Query query = entityManager.createNativeQuery(sb.toString(),Categoria.class);
		
		List<Categoria> result = query.getResultList();
		return result;
	}

	@Override
	public void save(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		if(categoria.getCcategoria()==null) {
			entityManager.persist(categoria);
		}else {
			entityManager.merge(categoria);
		}
	}
	
}
