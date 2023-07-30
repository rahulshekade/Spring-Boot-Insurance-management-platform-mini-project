package com.lic.Springbootinsurancemanagementplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lic.Springbootinsurancemanagementplatform.dto.InsurancePolicy;
import com.lic.Springbootinsurancemanagementplatform.dto.ResponseStructure;
import com.lic.Springbootinsurancemanagementplatform.service.InsurancePolicyService;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyService insurancePolicyService;
	
	// insert insurancePolicy------------------------------------------------------------------
	@PostMapping("/saveInsurancePolicy")
	public ResponseStructure<InsurancePolicy> insertInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		return insurancePolicyService.insertInsurancePolicy(insurancePolicy);
	}	
}
