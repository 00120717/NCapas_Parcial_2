package com.uca.capas.parcial2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.LibroDao;
import com.uca.capas.parcial2.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{

	LibroDao libroDao;
	
	public List<Libro> findAll() throws DataAccessException {
		
		return libroDao.findAll();
	}

	@Transactional
	public void save(Libro l) throws DataAccessException {
		libroDao.save(l);
	}

}
