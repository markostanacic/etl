package com.etl.shiftmanagement.sift.etlservice.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftBreaksDto implements Serializable {

	private static final long serialVersionUID = 5270077370293143155L;

	private Integer id;

	private Integer shift_id;

	private Integer timesheet_id;

	private LocalDate date;

	private Long start;

	private Long finish;

	private Long length;

	private Boolean paid;
}
