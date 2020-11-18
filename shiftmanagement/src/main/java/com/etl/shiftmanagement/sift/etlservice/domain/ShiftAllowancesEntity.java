package com.etl.shiftmanagement.sift.etlservice.domain;

import java.time.LocalDate;

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
@Table(name = "shift_allowances")
public class ShiftAllowancesEntity extends AuditEntity {

	@Id
	@Column
	private Integer id;

	@Column
	private Integer shift_id;

	@Column
	private Integer timesheet_id;

	@Column
	private LocalDate date;

	@Column
	private String name;

	@Column
	private Float value;

	@Column
	private Float cost;

}
