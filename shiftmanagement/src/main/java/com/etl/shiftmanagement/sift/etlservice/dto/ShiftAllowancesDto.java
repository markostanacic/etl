package com.etl.shiftmanagement.sift.etlservice.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftAllowancesDto {

	private Integer id;

	private Integer shift_id;

	private Integer timesheet_id;

	private LocalDate date;

	private String name;

	private Float value;

	private Float cost;
}
