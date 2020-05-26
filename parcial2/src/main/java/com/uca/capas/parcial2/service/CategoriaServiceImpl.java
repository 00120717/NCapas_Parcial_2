package com.uca.capas.parcial2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.CategoriaDao;
import com.uca.capas.parcial2.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	CategoriaDao categoriaDao;

	
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDao.findAll();
	}

	@Transactional
	public void save(Categoria c) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDao.save(c);
	}
	
	
}
