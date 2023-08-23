package com.lic.Springbootinsurancemanagementplatform.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lic.Springbootinsurancemanagementplatform.dto.Claim;
import com.lic.Springbootinsurancemanagementplatform.repository.ClaimRepository;

@Repository
public class ClaimDao {

	@Autowired
	private ClaimRepository claimRepository;
	
	//insert Claim------------------------------------------------------------------------------
	public Claim insertClaim(Claim claim) {
		return claimRepository.save(claim);	
	}
	
	// getByClaimId-----------------------------------------------------------------------------
	public Claim getByClaimId(int claimId) {
		Optional<Claim> optional = claimRepository.findById(claimId);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	// delete Claim-----------------------------------------------------------------------------
	public Claim deleteClaim(Claim claim, int claimId) {
		Optional<Claim> optional = claimRepository.findById(claimId);
		
		if(optional.isPresent()) {
			claimRepository.delete(optional.get());
			return claim;
		}else {
			return null;
		}
	}
	
	
}
