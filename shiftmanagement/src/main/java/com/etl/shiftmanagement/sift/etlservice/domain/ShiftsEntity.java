package com.etl.shiftmanagement.sift.etlservice.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.etl.shiftmanagement.sift.etlservice.config.AuditEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shifts")
public class ShiftsEntity extends AuditEntity {

	@Id
	@Column
	private Integer id;

	@Column
	private Integer timesheet_id;

	@Column
	private Integer user_id;

	@Column
	private LocalDate date;

	@Column
	private LocalDateTime start;

	@Column
	private LocalDateTime finish;

	@Column
	private Integer department_id;

	@Column
	private Integer sub_cost_centre;

	@Column
	private String tag;

	@Column
	private Integer tag_id;

	@Column
	private String status;

	@Column
	private String metadata;

	@Column
	private Integer leave_request_id;

	@Column
	private Integer shift_feedback_id;

	@Column
	private Integer approved_by;

	@Column
	private LocalDateTime approved_at;

	@Column
	private Integer record_id;

	@Column
	private String cost_breakdown;

}
