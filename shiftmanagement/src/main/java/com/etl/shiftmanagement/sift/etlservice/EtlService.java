package com.etl.shiftmanagement.sift.etlservice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.etl.shiftmanagement.sift.etlservice.domain.ShiftAllowancesEntity;
import com.etl.shiftmanagement.sift.etlservice.domain.ShiftAwardInterpretationEntity;
import com.etl.shiftmanagement.sift.etlservice.domain.ShiftBreaksEntity;
import com.etl.shiftmanagement.sift.etlservice.domain.ShiftsEntity;
import com.etl.shiftmanagement.sift.etlservice.dto.ShiftAllowancesDto;
import com.etl.shiftmanagement.sift.etlservice.dto.ShiftAwardInterpretationDto;
import com.etl.shiftmanagement.sift.etlservice.dto.ShiftBreaksDto;
import com.etl.shiftmanagement.sift.etlservice.dto.ShiftDto;
import com.etl.shiftmanagement.sift.etlservice.repository.ShiftAllowancesRepository;
import com.etl.shiftmanagement.sift.etlservice.repository.ShiftAwardInterpretationRepository;
import com.etl.shiftmanagement.sift.etlservice.repository.ShiftBreaksRepository;
import com.etl.shiftmanagement.sift.etlservice.repository.ShiftsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EtlService {

	private final ShiftsRepository shiftsRepository;

	private final ShiftBreaksRepository shiftBreaksRepository;

	private final ShiftAllowancesRepository shiftAllowancesRepository;

	private final ShiftAwardInterpretationRepository shiftAwardInterpretationRepository;

	private final String uri = "http://localhost:8081/api/v1/shifts";

	@PostConstruct
	public void getShifts() {

		log.debug("Getting shifts from REST endpoint started.");

		RestTemplate restTemplate = new RestTemplate();

		ShiftDto[] shiftDto = restTemplate.getForObject(uri, ShiftDto[].class);

		log.debug("Getting shifts from REST endpoint ended.");

		List<ShiftDto> searchList = Arrays.asList(shiftDto);

		List<ShiftsEntity> shiftsEntity = new ArrayList<>();

		List<ShiftAwardInterpretationEntity> shiftAwardInterpretarionEntityList = new ArrayList<>();

		log.debug("Started persisting to DB.");
		searchList.forEach(shift -> {

			// save shifts
			ShiftsEntity shiftEntity = new ShiftsEntity();
			shiftEntity = mapShiftsEntity(shift, shiftEntity);
			shiftsEntity.add(shiftEntity);

			// save shift breaks
			ShiftBreaksEntity shiftBreaksEntity = new ShiftBreaksEntity();
			shiftBreaksEntity = mapShiftBreaksEntity(shift.getBreaks(), shiftBreaksEntity);
			shiftBreaksRepository.save(shiftBreaksEntity);

			// save shift allowances
			ShiftAllowancesEntity shiftAllowancesEntity = new ShiftAllowancesEntity();
			shiftAllowancesEntity = mapShiftAllowancesEntity(shift.getShiftAllowances(), shiftAllowancesEntity);
			shiftAllowancesRepository.save(shiftAllowancesEntity);

			// save shift awardInterpretarion
			shift.getShiftAwardInterpretation().forEach(shiftAward -> {

				ShiftAwardInterpretationEntity shiftAwardInterpretationEntity = new ShiftAwardInterpretationEntity();
				shiftAwardInterpretationEntity = mapShiftAwartInterpretarionEntity(shiftAward,
						shiftAwardInterpretationEntity);

				shiftAwardInterpretarionEntityList.add(shiftAwardInterpretationEntity);

			});

		});

		shiftsRepository.saveAll(shiftsEntity);
		shiftAwardInterpretationRepository.saveAll(shiftAwardInterpretarionEntityList);

		log.debug("Ended persisting to DB.");

	}

	private ShiftAwardInterpretationEntity mapShiftAwartInterpretarionEntity(
			ShiftAwardInterpretationDto shiftAwardInterpretationDto,
			ShiftAwardInterpretationEntity shiftAwartInterpretarionEntity) {

		shiftAwartInterpretarionEntity.setId(shiftAwardInterpretationDto.getId());
		shiftAwartInterpretarionEntity.setShift_id(shiftAwardInterpretationDto.getShift_id());
		shiftAwartInterpretarionEntity.setTimesheet_id(shiftAwardInterpretationDto.getTimesheet_id());
		shiftAwartInterpretarionEntity.setDate(shiftAwardInterpretationDto.getDate());
		shiftAwartInterpretarionEntity.setUnits(shiftAwardInterpretationDto.getUnits());
		shiftAwartInterpretarionEntity.setExport_name(shiftAwardInterpretationDto.getExport_name());
		shiftAwartInterpretarionEntity.setSecondary_export_name(shiftAwardInterpretationDto.getSecondary_export_name());
		shiftAwartInterpretarionEntity.setOrdinary_hours(shiftAwardInterpretationDto.getOrdinary_hours());
		shiftAwartInterpretarionEntity.setCost(shiftAwardInterpretationDto.getCost());
		shiftAwartInterpretarionEntity.setStart(convertEpoch(shiftAwardInterpretationDto.getFrom()));
		shiftAwartInterpretarionEntity.setEnd(convertEpoch(shiftAwardInterpretationDto.getTo()));

		return shiftAwartInterpretarionEntity;
	}

	private ShiftAllowancesEntity mapShiftAllowancesEntity(ShiftAllowancesDto shiftAllowancesDto,
			ShiftAllowancesEntity shiftAllowancesEntity) {

		shiftAllowancesEntity.setId(shiftAllowancesDto.getId());
		shiftAllowancesEntity.setShift_id(shiftAllowancesDto.getShift_id());
		shiftAllowancesEntity.setTimesheet_id(shiftAllowancesDto.getTimesheet_id());
		shiftAllowancesEntity.setDate(shiftAllowancesDto.getDate());
		shiftAllowancesEntity.setName(shiftAllowancesDto.getName());
		shiftAllowancesEntity.setValue(shiftAllowancesDto.getValue());
		shiftAllowancesEntity.setCost(shiftAllowancesDto.getCost());

		return shiftAllowancesEntity;
	}

	private ShiftBreaksEntity mapShiftBreaksEntity(ShiftBreaksDto shiftBreaksDto, ShiftBreaksEntity shiftBreaksEntity) {
		shiftBreaksEntity.setId(shiftBreaksDto.getId());
		shiftBreaksEntity.setShift_id(shiftBreaksDto.getShift_id());
		shiftBreaksEntity.setTimesheet_id(shiftBreaksDto.getTimesheet_id());
		shiftBreaksEntity.setDate(shiftBreaksDto.getDate());
		shiftBreaksEntity.setStart(convertEpoch(shiftBreaksDto.getStart()));
		shiftBreaksEntity.setFinish(convertEpoch(shiftBreaksDto.getFinish()));
		shiftBreaksEntity.setLength(shiftBreaksDto.getLength());
		shiftBreaksEntity.setPaid(shiftBreaksDto.getPaid());

		return shiftBreaksEntity;
	}

	private LocalDateTime convertEpoch(Long time) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
	}

	private ShiftsEntity mapShiftsEntity(ShiftDto shift, ShiftsEntity shiftEntity) {
		shiftEntity.setId(shift.getId());
		shiftEntity.setTimesheet_id(shift.getTimesheet_id());
		shiftEntity.setUser_id(shift.getUser_id());
		shiftEntity.setDate(shift.getDate());
		shiftEntity.setStart(convertEpoch(shift.getStart()));
		shiftEntity.setFinish(convertEpoch(shift.getFinish()));
		shiftEntity.setDepartment_id(shift.getDepartment_id());
		shiftEntity.setSub_cost_centre(shift.getSub_cost_centre());
		shiftEntity.setTag(shift.getTag());
		shiftEntity.setTag_id(shift.getTag_id());
		shiftEntity.setStatus(shift.getStatus());
		shiftEntity.setMetadata(shift.getMetadata());
		shiftEntity.setLeave_request_id(shift.getLeave_request_id());
		shiftEntity.setShift_feedback_id(shift.getShift_feedback_id());
		shiftEntity.setApproved_at(convertEpoch(shift.getApproved_at()));
		shiftEntity.setApproved_by(shift.getApproved_by());
		shiftEntity.setRecord_id(shift.getRecord_id());
		shiftEntity.setCost_breakdown(StringUtils.join((shift.getCost_breakdown())));

		return shiftEntity;
	}

}
