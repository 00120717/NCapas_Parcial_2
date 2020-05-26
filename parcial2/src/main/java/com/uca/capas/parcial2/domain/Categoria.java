package com.uca.capas.parcial2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name="cat_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(generator="cat_categoria_c_categoria_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="cat_categoria_c_categoria_seq",sequenceName="public.cat_categoria_c_categoria_seq", allocationSize = 1)
	@Column(name = "c_categoria")
	private Integer ccategoria;
	
	@Column(name = "s_categoria")
	@Size(message = "El campo sobrepasa la cantidad de 50 caracteres",max = 50)
	@NotNull(message = "El campo Categoria categoría no puede estar vacío")
	private String scategoria;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "categoria")
	private List<Libro> libros;

	public Integer getCcategoria() {
		return ccategoria;
	}

	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}

	public String getScategoria() {
		return scategoria;
	}

	public void setScategoria(String scategoria) {
		this.scategoria = scategoria;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
}
