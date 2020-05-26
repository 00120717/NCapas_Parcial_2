package com.uca.capas.parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Categoria;

public interface CategoriaDao {
	public List<Categoria> findAll() throws DataAccessException;
	
	public void save(Categoria categoria) throws DataAccessException;
}
