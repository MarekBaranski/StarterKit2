package com.capgemini.chess.service.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractTo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	@Column(columnDefinition = "integer DEFAULT 0")
	private int version;
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
}
