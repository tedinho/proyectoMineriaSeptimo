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
 * Clase entidad (EJB) para tabla 'orden_trabajo'
 * 
 * @author Duval Barragan
 *
 */
@Entity
@Table(name = "orden_trabajo")
@TableGenerator(table = "secuencia", name = "sec_orden_trabajo", pkColumnName = "nombre", pkColumnValue = "orden_trabajo", valueColumnName = "sig_valor", allocationSize = 1)

public class OrdenTrabajo implements Serializable {

	private static final long serialVersionUID = -4722015191261065733L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sec_orden_trabajo")
	private Long id;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_orden_trabajo"))
	private Cliente cliente;

	@Column(name = "numero", length = 150, nullable = true)
	private String numero;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 32, nullable = false)
	private EstadoEnum estado;// EstadoEnum

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonbDateFormat("yyyy-MM-dd")
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	@Column(name = "fecha_ingreso", nullable = true)
	private LocalDate fechaIngreso;

	@Column(name = "cantidad", nullable = true)
	private Integer cantidad;//

	@Column(name = "sub_total", columnDefinition = "numeric(12,2)")
	private BigDecimal subTotal;

	@Column(name = "iva", columnDefinition = "numeric(12,2)")
	private BigDecimal iva;

	@Column(name = "total", columnDefinition = "numeric(12,2)")
	private BigDecimal total;

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

	@Column(name = "presentacion_llegada", length = 500, nullable = true)
	private String presentacionLlegada;

	@ManyToOne
	@JoinColumn(name = "id_tecnico_responsable", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "fk_orden_trabajo_tecnico"))
	private TecnicoArea tecnicoResponsable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public LocalDate getFechaRecoleccion() {
		return fechaRecoleccion;
	}

	public void setFechaRecoleccion(LocalDate fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getCondicionAlmacenamiento() {
		return condicionAlmacenamiento;
	}

	public void setCondicionAlmacenamiento(String condicionAlmacenamiento) {
		this.condicionAlmacenamiento = condicionAlmacenamiento;
	}

	public String getUbicacionTemporal() {
		return ubicacionTemporal;
	}

	public void setUbicacionTemporal(String ubicacionTemporal) {
		this.ubicacionTemporal = ubicacionTemporal;
	}

	public String getPresentacionLlegada() {
		return presentacionLlegada;
	}

	public void setPresentacionLlegada(String presentacionLlegada) {
		this.presentacionLlegada = presentacionLlegada;
	}

	public TecnicoArea getTecnicoResponsable() {
		return tecnicoResponsable;
	}

	public void setTecnicoResponsable(TecnicoArea tecnicoResponsable) {
		this.tecnicoResponsable = tecnicoResponsable;
	}

}
