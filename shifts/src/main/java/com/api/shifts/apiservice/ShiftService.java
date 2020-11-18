package com.api.shifts.apiservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ShiftService {

	public List<Shift> getShifts() {

		int randomNum = EtlUtils.genererateRandomInt(50);

		List<Shift> shiftList = new ArrayList<>();

		for (int i = 0; i < randomNum; i++) {
			shiftList.add(new Shift());
		}
		

		return shiftList;
	}

}
