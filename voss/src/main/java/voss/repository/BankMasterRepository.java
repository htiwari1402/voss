package voss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import voss.entity.BankMasterEntity;

import java.util.List;

public interface BankMasterRepository extends JpaRepository<BankMasterEntity, String> {
	  List<BankMasterEntity> findAll();
	  BankMasterEntity findByBankID(int id);
	}
