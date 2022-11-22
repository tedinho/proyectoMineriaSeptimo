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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Clase entidad (EJB) para tabla 'area'
 * 
 * @author Duval Barragan
 *
 */
@Entity
@Table(name = "muestra_orden_trabajo")
@TableGenerator(table = "secuencia", name = "sec_ubicacion_muestra", pkColumnName = "nombre", pkColumnValue = "muestra_orden_trabajo", valueColumnName = "sig_valor", allocationSize = 1)

public class MuestraOrdenTrabajo implements Serializable {

	private static final long serialVersionUID = -4722015191261065733L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sec_ubicacion_muestra")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_muestra", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_ot_muestra_muestra"))
	private Muestra muestra;

	@ManyToOne
	@JoinColumn(name = "id_servicio", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_ot_muestra_servicio"))
	private Servicio servicio;

	@Column(name = "cantidad", nullable = true)
	private Integer repeticiones;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_tecnico_area", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "fk_muestra_orden_trabajo_tecnico_area"))
	private TecnicoArea tecnicoArea;

	@ManyToOne
	@JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_muestra_ot_orden_trabajo"))
	private OrdenTrabajo ordenTrabajo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Muestra getMuestra() {
		return muestra;
	}

	public void setMuestra(Muestra muestra) {
		this.muestra = muestra;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public TecnicoArea getTecnicoArea() {
		return tecnicoArea;
	}

	public void setTecnicoArea(TecnicoArea tecnicoArea) {
		this.tecnicoArea = tecnicoArea;
	}

	public OrdenTrabajo getOrdenTrabajo() {
		return ordenTrabajo;
	}

	public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
	}

	public Integer getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(Integer repeticiones) {
		this.repeticiones = repeticiones;
	}

}
