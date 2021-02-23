package com.meli.quasar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuasarResult {

	private Position position;
	private String message;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
