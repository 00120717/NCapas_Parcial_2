package com.uca.capas.parcial2.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.parcial2.domain.Categoria;
import com.uca.capas.parcial2.domain.Libro;
import com.uca.capas.parcial2.service.CategoriaService;
import com.uca.capas.parcial2.service.LibroService;
import java.sql.Timestamp;

@Controller
public class MainController {
	
	@Autowired
	LibroService libroService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/categoria")
	public ModelAndView saveCategorias(@Valid @ModelAttribute Categoria categoria, BindingResult result) throws DataAccessException{
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			
			mav.addObject("categoria",categoria);
            mav.setViewName("categoria");
		}else {
			categoriaService.save(categoria);
			mav.addObject("exito", 1);
			mav.setViewName("index");
		}
		
		return mav;		
	}
	
	@RequestMapping("/libro")
	public ModelAndView saveLibros(@Valid @ModelAttribute Libro libro, BindingResult result) throws DataAccessException{
		ModelAndView mav = new ModelAndView();
		 List<Categoria> categorias= null;
		 categorias = categoriaService.findAll();
		 mav.addObject("categorias", categorias);
			
		 	long millis=System.currentTimeMillis();  
			Timestamp sdate=new java.sql.Timestamp(millis);  
			
			if (result.hasErrors()) {
				mav.addObject("libro", libro);
				mav.setViewName("libro");
			} else {
				libro.setFingreso(sdate);
				libroService.save(libro);
				mav.addObject("resultado", 2);
				mav.setViewName("index");
			}
	        return mav;	
	}
	
	@RequestMapping("/listalibros")
	public ModelAndView listado() throws DataAccessException{
		ModelAndView mav = new ModelAndView();
		List<Libro> libros= null;
		
		try {
			libros = libroService.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.addObject("libros",libros);
		mav.setViewName("listaLibros");
		
		return mav;
	}
}
