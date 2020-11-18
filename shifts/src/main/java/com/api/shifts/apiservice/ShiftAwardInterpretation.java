package com.api.shifts.apiservice;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftAwardInterpretation implements Serializable {

	private static final long serialVersionUID = 5100278997426080293L;
	
	private Integer id = EtlUtils.generateRandomInteger();
	

	public ShiftAwardInterpretation(Integer shift_id, Integer timesheet_id, LocalDate shift_date) {
		super();
		this.shift_id = shift_id;
		this.timesheet_id = timesheet_id;
		this.date = shift_date;
	}
	
	private Integer shift_id;

	private Integer timesheet_id;

	private LocalDate date;
	
	private Float units = EtlUtils.generateRandomFloat();

	private String export_name = EtlUtils.generateRandomString();
	
	private String secondary_export_name = EtlUtils.generateRandomString();
	
	private Boolean ordinary_hours = EtlUtils.generateRandomBoolean();
	
	private Float cost = EtlUtils.generateRandomFloat();
	
	private Long from = System.currentTimeMillis();
	
	private Long to = System.currentTimeMillis();

}
