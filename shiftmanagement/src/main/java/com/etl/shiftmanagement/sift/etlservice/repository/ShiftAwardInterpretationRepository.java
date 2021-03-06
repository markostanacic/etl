package com.etl.shiftmanagement.sift.etlservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.etl.shiftmanagement.sift.etlservice.domain.ShiftAwardInterpretationEntity;

@Repository
public interface ShiftAwardInterpretationRepository extends CrudRepository<ShiftAwardInterpretationEntity, Integer> {

}
