/*
* Producto.java
* 
* Copyright (c) Saviasoft. Todos los derechos reservados.
*
* 23/marzo/2017
*/
package com.uisrael.mineria.mineriadatos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.saviasoft.util.constante.EstadoEnum;

/**
 * Clase entidad (EJB) para tabla 'area'
 * 
 * @author Duval Barragan
 *
 */
@Entity
@Table(name = "servicio")
@TableGenerator(table = "secuencia", name = "sec_servicio", pkColumnName = "nombre", pkColumnValue = "servicio", valueColumnName = "sig_valor", allocationSize = 1)

public class Servicio implements Serializable {

	private static final long serialVersionUID = -4722015191261065733L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sec_servicio")
	private Long id;

	@Column(name = "nombre", length = 150, nullable = false)
	private String nombre;

	@Column(name = "ensayos", length = 150, nullable = false)
	private String ensayos;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 1, nullable = false)
	private EstadoEnum estado;// EstadoEnum

	@Column(name = "costo_clientes_internos", columnDefinition = "numeric(12,2)", nullable = true)
	private BigDecimal costoClientesInternos;

	@Column(name = "costo_clientes_externos", columnDefinition = "numeric(12,2)", nullable = true)
	private BigDecimal costoClientesExternos;

	@Column(name = "costo_laboratorio", columnDefinition = "numeric(12,2)", nullable = true)
	private BigDecimal costoLaboratorio;

	@Transient
	private String nombreCompletoTransient;

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

	public String getEnsayos() {
		return ensayos;
	}

	public void setEnsayos(String ensayos) {
		this.ensayos = ensayos;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public BigDecimal getCostoClientesInternos() {
		return costoClientesInternos;
	}

	public BigDecimal getCostoClientesExternos() {
		return costoClientesExternos;
	}

	public BigDecimal getCostoLaboratorio() {
		return costoLaboratorio;
	}

	public void setCostoClientesInternos(BigDecimal costoClientesInternos) {
		this.costoClientesInternos = costoClientesInternos;
	}

	public void setCostoClientesExternos(BigDecimal costoClientesExternos) {
		this.costoClientesExternos = costoClientesExternos;
	}

	public void setCostoLaboratorio(BigDecimal costoLaboratorio) {
		this.costoLaboratorio = costoLaboratorio;
	}

	public String getNombreCompletoTransient() {
		nombreCompletoTransient = this.nombre + " - " + this.ensayos;
		return nombreCompletoTransient;
	}

	public void setNombreCompletoTransient(String nombreCompletoTransient) {
		this.nombreCompletoTransient = nombreCompletoTransient;
	}

}
