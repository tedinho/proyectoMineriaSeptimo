package com.uisrael.mineria.mineriadatos.dto;

import java.io.Serializable;

public class RespuestaDto implements Serializable {

	private static final long serialVersionUID = 5275072254463070079L;

	public Integer contador;

	public String nombre;

	public String aux;

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

}
