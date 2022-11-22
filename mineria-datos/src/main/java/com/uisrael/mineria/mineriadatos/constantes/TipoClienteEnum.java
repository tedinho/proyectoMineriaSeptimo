package com.uisrael.mineria.mineriadatos.constantes;

public enum TipoClienteEnum {

	I("Interno"), E("Externo");

	private String etiqueta;

	private TipoClienteEnum(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public boolean isInterno() {
		return this.equals(I);
	}

	public boolean isExterno() {
		return this.equals(E);
	}

}
