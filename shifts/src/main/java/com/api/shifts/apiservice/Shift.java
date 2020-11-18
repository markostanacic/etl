package com.api.shifts.apiservice;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;

@Getter
public class Shift implements Serializable {

	private static final long serialVersionUID = -8364894590549816784L;

	private Integer id = EtlUtils.generateRandomInteger();

	private Integer timesheet_id = EtlUtils.generateRandomInteger();

	private Integer user_id = EtlUtils.generateRandomInteger();

	private LocalDate date = EtlUtils.generateRandomDate(LocalDate.of(2020, Month.OCTOBER, 14), LocalDate.now());

	private Long start = System.currentTimeMillis();

	private Long finish = System.currentTimeMillis();

	private Integer department_id = EtlUtils.generateRandomInteger();

	private Integer sub_cost_centre = EtlUtils.generateRandomInteger();

	private String tag = EtlUtils.generateRandomString();

	private Integer tag_id = EtlUtils.generateRandomInteger();

	private String status = EtlUtils.generateRandomString();

	private String metadata = EtlUtils.generateRandomString();

	private Integer leave_request_id = EtlUtils.generateRandomInteger();

	private Integer shift_feedback_id = EtlUtils.generateRandomInteger();

	private Integer approved_by = EtlUtils.generateRandomInteger();

	private Long approved_at = System.currentTimeMillis();

	private Integer record_id = EtlUtils.generateRandomInteger();

	private Map<String, Integer> cost_breakdown = Stream
			.of(new Object[][] { { "award_cost", EtlUtils.generateRandomInteger() },
					{ "allowance_cost", EtlUtils.generateRandomInteger() }, })
			.collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

	private ShiftBreaks breaks = new ShiftBreaks(id, timesheet_id, date);

	private ShiftAllowances shiftAllowances = new ShiftAllowances(id, timesheet_id, date);

	private List<ShiftAwardInterpretation> shiftAwardInterpretation = Stream.of(
			new ShiftAwardInterpretation(id, timesheet_id, date), new ShiftAwardInterpretation(id, timesheet_id, date),
			new ShiftAwardInterpretation(id, timesheet_id, date)).collect(Collectors.toList());

}
