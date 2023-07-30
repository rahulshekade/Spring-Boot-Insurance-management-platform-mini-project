package com.lic.Springbootinsurancemanagementplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lic.Springbootinsurancemanagementplatform.dao.InsurancePolicyDao;
import com.lic.Springbootinsurancemanagementplatform.dto.InsurancePolicy;
import com.lic.Springbootinsurancemanagementplatform.dto.ResponseStructure;

@Service
public class InsurancePolicyService {

	@Autowired
	private InsurancePolicyDao insurancePolicyDao;
	
	@Autowired
	private ResponseStructure<InsurancePolicy> responseStructure;
	
	// insert insurancePolicy-----------------------------------------------------------
	public ResponseStructure<InsurancePolicy> insertInsurancePolicy(InsurancePolicy insurancePolicy) {
		InsurancePolicy insurancePolicy2 = insurancePolicyDao.insertInsurancePolicy(insurancePolicy);
		
		if(insurancePolicy2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("data inserted successfully");
			responseStructure.setData(insurancePolicy2);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("data not inserted please check again your code");
			responseStructure.setData(null);
			return responseStructure;
		}
	}	
}
