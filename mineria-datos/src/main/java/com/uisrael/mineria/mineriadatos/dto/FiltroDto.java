package com.uisrael.mineria.mineriadatos.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class FiltroDto implements Serializable {

	private static final long serialVersionUID = -8657165066268348887L;

	public LocalDate fechaInicio;

	public LocalDate fechaFin;

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

}
