package com.api.shifts.apiservice;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftBreaks implements Serializable {

	private static final long serialVersionUID = -5309759448778912927L;

	private Integer id = EtlUtils.generateRandomInteger();

	public ShiftBreaks(Integer shift_id, Integer timesheet_id, LocalDate shift_date) {
		super();
		this.shift_id = shift_id;
		this.timesheet_id = timesheet_id;
		this.date = shift_date;
	}

	private Integer shift_id;

	private Integer timesheet_id;

	private LocalDate date;

	private Long start = System.currentTimeMillis();

	private Long finish = System.currentTimeMillis();

	private Long length = System.currentTimeMillis();

	private Boolean paid = EtlUtils.generateRandomBoolean();

}
