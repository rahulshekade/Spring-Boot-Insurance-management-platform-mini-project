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
	
	// getByInsurancePolicyId------------------------------------------------------------
	public ResponseStructure<InsurancePolicy> getByInsurancePolicyId(int insurancePolicyId) {
		InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyId(insurancePolicyId);
		
		if(insurancePolicy != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("data fetch successfull, data is available");
			responseStructure.setData(insurancePolicy);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("please check your id which you are given");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
	
	// update Insurance Policy------------------------------------------------------------
	public ResponseStructure<InsurancePolicy> updateInsurancePolicy(InsurancePolicy insurancePolicy, int insurancePolicyId) {
		InsurancePolicy insurancePolicy2 = insurancePolicyDao.updateInsurancePolicy(insurancePolicy, insurancePolicyId);
		
		if(insurancePolicy2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data is updated suceesfully because id is present");
			responseStructure.setData(insurancePolicy2);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("given id is not present in database");
			responseStructure.setData(null);
			return responseStructure;
		}
	}	
}
