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
@Table(name = "tipo_muestra")
@TableGenerator(table = "secuencia", name = "sec_tipo_muestra", pkColumnName = "nombre", pkColumnValue = "tipo_muestra", valueColumnName = "sig_valor", allocationSize = 1)

public class TipoMuestra implements Serializable {

	private static final long serialVersionUID = -4722015191261065733L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sec_tipo_muestra")
	private Long id;

	@Column(name = "nombre", length = 150, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 150, nullable = false)
	private String descripcion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 1, nullable = false)
	private EstadoEnum estado;// EstadoEnum

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

}
