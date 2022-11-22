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
import com.uisrael.mineria.mineriadatos.constantes.TipoClienteEnum;

/**
 * Clase entidad (EJB) para tabla 'area'
 * 
 * @author Duval Barragan
 *
 */
@Entity
@Table(name = "cliente")
@TableGenerator(table = "secuencia", name = "sec_cliente", pkColumnName = "nombre", pkColumnValue = "cliente", valueColumnName = "sig_valor", allocationSize = 1)

public class Cliente implements Serializable {

	private static final long serialVersionUID = -4722015191261065733L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sec_cliente")
	private Long id;

	@Column(name = "nombre", length = 150, nullable = false)
	private String nombre;

	@Column(name = "nombre_empresa", length = 150, nullable = true)
	private String nombreEmpresa;

	@Column(name = "ruc", length = 150, nullable = true)
	private String ruc;

	@Column(name = "telefono", length = 150, nullable = true)
	private String numeroContacto;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 1, nullable = false)
	private TipoClienteEnum tipo;//

	@Column(name = "correo", length = 100, nullable = false)
	private String correo;//

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

	public TipoClienteEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoClienteEnum tipo) {
		this.tipo = tipo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public String getRuc() {
		return ruc;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

}
