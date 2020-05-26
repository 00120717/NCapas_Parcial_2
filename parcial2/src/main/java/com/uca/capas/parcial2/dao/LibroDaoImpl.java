package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.Libro;


@Repository
public class LibroDaoImpl implements LibroDao{
	
	@PersistenceContext(name = "capas")
	EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.cat_libro");
		
		Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		
		List<Libro> result = query.getResultList();
		return result;
	}

	@Override
	public void save(Libro libro) throws DataAccessException {
		if(libro.getClibro()==null) {
			entityManager.persist(libro);
		}else {
			entityManager.merge(libro);
		}
	}

}
