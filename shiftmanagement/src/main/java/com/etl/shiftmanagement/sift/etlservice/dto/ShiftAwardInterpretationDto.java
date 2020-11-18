package com.etl.shiftmanagement.sift.etlservice.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftAwardInterpretationDto implements Serializable {

	private static final long serialVersionUID = -2126602336940053175L;

	private Integer id;

	private Integer shift_id;

	private Integer timesheet_id;

	private LocalDate date;

	private Float units;

	private String export_name;

	private String secondary_export_name;

	private Boolean ordinary_hours;

	private Float cost;

	private Long from;

	private Long to;
}
