package com.aula.virtual.response;

import java.io.Serializable;

public class GeneralResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 271225070751715797L;
	private String status;
	private String mensaje;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
