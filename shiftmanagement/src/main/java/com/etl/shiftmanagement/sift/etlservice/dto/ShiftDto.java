package com.etl.shiftmanagement.sift.etlservice.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftDto implements Serializable {

	private static final long serialVersionUID = -1496956407794591154L;

	private Integer id;

	private Integer timesheet_id;

	private Integer user_id;

	private LocalDate date;

	private Long start;

	private Long finish;

	private Integer department_id;

	private Integer sub_cost_centre;

	private String tag;

	private Integer tag_id;

	private String status;

	private String metadata;

	private Integer leave_request_id;

	private Integer shift_feedback_id;

	private Integer approved_by;

	private Long approved_at;

	private Integer record_id;

	private Map<String, Integer> cost_breakdown;

	private ShiftBreaksDto breaks;

	private ShiftAllowancesDto shiftAllowances;

	private List<ShiftAwardInterpretationDto> shiftAwardInterpretation;
}
