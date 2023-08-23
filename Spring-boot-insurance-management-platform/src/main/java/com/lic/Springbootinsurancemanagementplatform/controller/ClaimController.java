package com.lic.Springbootinsurancemanagementplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lic.Springbootinsurancemanagementplatform.dto.Claim;
import com.lic.Springbootinsurancemanagementplatform.dto.ResponseStructure;
import com.lic.Springbootinsurancemanagementplatform.service.ClaimService;

@RestController
@RequestMapping("/api")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	//insert Claim---------------------------------------------------------------------
	@PostMapping("/saveClaim/{policyId}")
	public ResponseStructure<Claim> insertClaim(@RequestBody Claim claim,@PathVariable int policyId) {
		return claimService.insertClaim(claim, policyId);
	}	
	
	// getByClaimId-----------------------------------------------------------------------------
	@GetMapping("/getByClaimId/{claimId}")
	public ResponseStructure<Claim> getByClaimId(@PathVariable int claimId) {
		return claimService.getByClaimId(claimId);
	}
	
	// delete Claim-----------------------------------------------------------------------------
	@DeleteMapping("/deleteClaim/{claimId}")
	public ResponseStructure<Claim> deleteClaim(Claim claim, @PathVariable int claimId) {
		return claimService.deleteClaim(claim, claimId);
	}	
}
