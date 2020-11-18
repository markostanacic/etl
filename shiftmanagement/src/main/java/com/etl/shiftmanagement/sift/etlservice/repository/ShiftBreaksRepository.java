package com.etl.shiftmanagement.sift.etlservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.etl.shiftmanagement.sift.etlservice.domain.ShiftBreaksEntity;

@Repository
public interface ShiftBreaksRepository extends CrudRepository<ShiftBreaksEntity, Integer> {

}
