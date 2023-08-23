package com.lic.Springbootinsurancemanagementplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lic.Springbootinsurancemanagementplatform.dao.ClaimDao;
import com.lic.Springbootinsurancemanagementplatform.dao.InsurancePolicyDao;
import com.lic.Springbootinsurancemanagementplatform.dto.Claim;
import com.lic.Springbootinsurancemanagementplatform.dto.InsurancePolicy;
import com.lic.Springbootinsurancemanagementplatform.dto.ResponseStructure;

@Service
public class ClaimService {

	@Autowired
	private ClaimDao claimDao;
	
	@Autowired
	private InsurancePolicyDao insurancePolicyDao;
	
	@Autowired
	private ResponseStructure<Claim> responseStructure;
	
	//insert Claim---------------------------------------------------------------------
	public ResponseStructure<Claim> insertClaim(Claim claim, int policyId) {
		InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyId(policyId);
		
		if(insurancePolicy != null) {
			claim.setInsurancePolicy(insurancePolicy);
			claimDao.insertClaim(claim);
			
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Claimed successfully");
			responseStructure.setData(claim);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Not Cliamed yet please check again ");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
	
	// getByClaimId-----------------------------------------------------------------------------
	public ResponseStructure<Claim> getByClaimId(int claimId) {
		Claim claim = claimDao.getByClaimId(claimId);
		
		if(claim != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("this calim id is present");
			responseStructure.setData(claim);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("please check claim id it is not present in our database");
			responseStructure.setData(null);
			return responseStructure;
		}
	}	
	
	// delete Claim-----------------------------------------------------------------------------
	public ResponseStructure<Claim> deleteClaim(Claim claim, int claimId) {
		Claim claim2 = claimDao.deleteClaim(claim, claimId);
		
		if(claim2 != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Claim deleted successfully");
			responseStructure.setData(claim2);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Claim is not deleted ");
			responseStructure.setData(null);
			return responseStructure;
		}
	}	
}
