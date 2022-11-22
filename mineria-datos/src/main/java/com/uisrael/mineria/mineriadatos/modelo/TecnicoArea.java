/*
* Producto.java
* 
* Copyright (c) Saviasoft. Todos los derechos reservados.
*
* 23/marzo/2017
*/
package com.uisrael.mineria.mineriadatos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.saviasoft.util.constante.EstadoEnum;

/**
 * Clase entidad (EJB) para tabla 'area'
 * 
 * @author Duval Barragan
 *
 */
@Entity
@Table(name = "tecnico_area")
@TableGenerator(table = "secuencia", name = "sec_tecnico_area", pkColumnName = "nombre", pkColumnValue = "tecnico_area", valueColumnName = "sig_valor", allocationSize = 1)

public class TecnicoArea implements Serializable {

	private static final long serialVersionUID = -4722015191261065733L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sec_tecnico_area")
	private Long id;

	@Column(name = "cargo", length = 100, nullable = false)
	private String cargo;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 1, nullable = false)
	private EstadoEnum estado;// EstadoEnum

	@Column(name = "area", length = 500, nullable = false)
	private String area;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
