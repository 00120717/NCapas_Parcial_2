package com.uca.capas.parcial2.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(schema = "public", name="cat_libro")
public class Libro {
	
	@Id
	@Column(name = "c_libro")
	@GeneratedValue(generator = "cat_libro_c_libro_seq",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq",sequenceName = "public.cat_libro_c_libro_seq",allocationSize = 1)
	private Integer clibro;
	
	@Column(name = "s_titulo")
	@Size(message = "El campo sobrepasa la cantidad de 500 caracteres",max = 500)
	@NotNull(message = "El campo nombre categoría no puede estar vacío")
	private String stitulo;
	
	@Column(name="s_autor")
	@Size(message = "El campo sobrepasa la cantidad de 150 caracteres",max = 150)
	@NotNull(message = "El campo Autor categoría no puede estar vacío")
	private String sautor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria",unique = true, insertable = false, updatable = false)
	private Categoria categoria;
	
	@Column(name = "f_ingreso")
	private Timestamp fingreso;
	
	@Column(name = "b_estado")
	private Boolean bestado;
	
	@Column(name = "s_isbn")
	@Size(message = "El campo sobrepasa la cantidad de 10 caracteres",max = 10)
	@NotNull(message = "El campo nombre categoría no puede estar vacío")
	private String sisbn;
	
	@Column(name = "c_categoria")
	@NotNull(message = "Debe seleccionar una opcion")
	private Integer ccategoria;

	public Integer getClibro() {
		return clibro;
	}

	public void setClibro(Integer clibro) {
		this.clibro = clibro;
	}

	public String getStitulo() {
		return stitulo;
	}

	public void setStitulo(String stitulo) {
		this.stitulo = stitulo;
	}

	public String getSautor() {
		return sautor;
	}

	public void setSautor(String sautor) {
		this.sautor = sautor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Timestamp getFingreso() {
		return fingreso;
	}

	public void setFingreso(Timestamp fingreso) {
		this.fingreso = fingreso;
	}

	public Boolean getBestado() {
		return bestado;
	}

	public void setBestado(Boolean bestado) {
		this.bestado = bestado;
	}

	public String getSisbn() {
		return sisbn;
	}

	public void setSisbn(String sisbn) {
		this.sisbn = sisbn;
	}

	public Integer getCcategoria() {
		return ccategoria;
	}

	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}
	
	//Delegate para estado
	public String getBestadoDelegate(){
		if(this.bestado == null){
			return "";
		}
		else{
			if(this.bestado) return "ACTIVO";
			else return "INACTIVO";
		}
	}
	
	//Delegate para conversion de fecha
			public String getFechaDelegate(){
				if(this.fingreso == null){
					return "";
				}
				else{
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
					String shortdate = sdf.format(this.fingreso.getTime());
					return shortdate;
				}
			}
	
}
