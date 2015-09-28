package voss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import voss.entity.BankMasterEntity;
import voss.entity.BusinessUnitEntity;

import java.util.List;

public interface BusinessUnitRepository extends JpaRepository<BusinessUnitEntity, String> {
	  List<BusinessUnitEntity> findAll();
	  BusinessUnitEntity findByBuID(int id);
	}
