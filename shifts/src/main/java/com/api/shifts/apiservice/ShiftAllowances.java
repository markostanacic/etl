package com.api.shifts.apiservice;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftAllowances implements Serializable {

	private static final long serialVersionUID = 7778436875243881196L;

	private Integer id = EtlUtils.generateRandomInteger();

	private Integer shift_id;

	private Integer timesheet_id;

	private LocalDate date;

	public ShiftAllowances(Integer shift_id, Integer timesheet_id, LocalDate shift_date) {
		super();
		this.shift_id = shift_id;
		this.timesheet_id = timesheet_id;
		this.date = shift_date;
	}

	private String name = EtlUtils.generateRandomString();

	private Float value = EtlUtils.generateRandomFloat();

	private Float cost = EtlUtils.generateRandomFloat();

}
