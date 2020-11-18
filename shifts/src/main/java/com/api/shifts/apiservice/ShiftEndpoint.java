package com.api.shifts.apiservice;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class ShiftEndpoint {

	private final ShiftService shiftService;

	@GetMapping(path = "/shifts")
	public ResponseEntity<List<Shift>> getShift() {
		return ResponseEntity.ok(shiftService.getShifts());
	}

}
