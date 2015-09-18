package voss.repository;

import org.springframework.data.repository.CrudRepository;

import voss.entity.BankMasterEntity;

import java.util.List;

public interface BankMasterRepository extends CrudRepository<BankMasterEntity, String> {
	  List<BankMasterEntity> findAll();
	}
