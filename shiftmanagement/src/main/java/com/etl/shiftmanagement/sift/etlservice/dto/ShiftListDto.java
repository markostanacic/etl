package com.etl.shiftmanagement.sift.etlservice.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftListDto implements Serializable {

	private static final long serialVersionUID = 1123326466734128339L;
	private List<ShiftDto> shiftDtoList;

	public ShiftListDto() {
		shiftDtoList = new ArrayList<>();

	}

}
