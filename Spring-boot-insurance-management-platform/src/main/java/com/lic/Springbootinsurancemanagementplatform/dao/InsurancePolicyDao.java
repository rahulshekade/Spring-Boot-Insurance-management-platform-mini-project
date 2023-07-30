package com.lic.Springbootinsurancemanagementplatform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lic.Springbootinsurancemanagementplatform.dto.InsurancePolicy;
import com.lic.Springbootinsurancemanagementplatform.repository.InsurancePolicyRepository;

@Repository
public class InsurancePolicyDao {
	
	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	// insert insurancePolicy-----------------------------------------------------------
	public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}

}
