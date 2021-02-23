package com.meli.quasar.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Position {

	private double x;
	private double y;

	public Position(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@JsonIgnore
	public double[] getPoint() {
		return new double[] { x, y };
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
