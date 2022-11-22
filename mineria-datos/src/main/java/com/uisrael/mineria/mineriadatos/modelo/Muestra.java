/*
* Producto.java
* 
* Copyright (c) Saviasoft. Todos los derechos reservados.
*
* 23/marzo/2017
*/
package com.uisrael.mineria.mineriadatos.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.saviasoft.util.constante.EstadoEnum;
import com.uisrael.mineria.mineriadatos.adapter.LocalDateAdapter;

/**
 * Clase entidad (EJB) para tabla 'area'
 * 
 * @author Duval Barragan
 *
 */
@Entity
@Table(name = "muestra")
@TableGenerator(table = "secuencia", name = "sec_muestra", pkColumnName = "nombre", pkColumnValue = "muestra", valueColumnName = "sig_valor", allocationSize = 1)

public class Muestra implements Serializable {

	private static final long serialVersionUID = -4722015191261065733L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sec_muestra")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_tipo_muestra", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_muetra_tipo_muestra"))
	private TipoMuestra tipoMuestra;

	@Column(name = "nombre", length = 150, nullable = false)
	private String nombre;//

	@Column(name = "codigo_muestra", length = 500, nullable = true)
	private String codigoMuestra;//

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_muestra"))
	private Cliente cliente;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonbDateFormat("yyyy-MM-dd")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@Column(name = "fecha_ingreso", nullable = true)
	private LocalDate fechaIngreso;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 1, nullable = false)
	private EstadoEnum estado;// EstadoEnum

	@Column(name = "cantidad", nullable = true)
	private Integer cantidad;//

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonbDateFormat("yyyy-MM-dd")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@Column(name = "fecha_elimina", nullable = true)
	private LocalDate fechaElimina;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonbDateFormat("yyyy-MM-dd")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@Column(name = "fecha_recoleccion", nullable = true)
	private LocalDate fechaRecoleccion;

	@Column(name = "temperatura", length = 150, nullable = true)
	private String temperatura;//

	@Column(name = "condicion_almacenamiento", length = 500, nullable = true)
	private String condicionAlmacenamiento;//

	@Column(name = "ubicacion_temporal", length = 500, nullable = true)
	private String ubicacionTemporal;//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMuestra getTipoMuestra() {
		return tipoMuestra;
	}

	public void setTipoMuestra(TipoMuestra tipoMuestra) {
		this.tipoMuestra = tipoMuestra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFechaElimina() {
		return fechaElimina;
	}

	public void setFechaElimina(LocalDate fechaElimina) {
		this.fechaElimina = fechaElimina;
	}

	public String getCodigoMuestra() {
		return codigoMuestra;
	}

	public void setCodigoMuestra(String codigoMuestra) {
		this.codigoMuestra = codigoMuestra;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaRecoleccion() {
		return fechaRecoleccion;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public String getCondicionAlmacenamiento() {
		return condicionAlmacenamiento;
	}

	public String getUbicacionTemporal() {
		return ubicacionTemporal;
	}

	public void setFechaRecoleccion(LocalDate fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public void setCondicionAlmacenamiento(String condicionAlmacenamiento) {
		this.condicionAlmacenamiento = condicionAlmacenamiento;
	}

	public void setUbicacionTemporal(String ubicacionTemporal) {
		this.ubicacionTemporal = ubicacionTemporal;
	}

}
