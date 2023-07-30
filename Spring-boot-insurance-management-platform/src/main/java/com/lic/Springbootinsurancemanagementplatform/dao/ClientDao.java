package com.lic.Springbootinsurancemanagementplatform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lic.Springbootinsurancemanagementplatform.dto.Client;
import com.lic.Springbootinsurancemanagementplatform.repository.ClientRepository;

@Repository
public class ClientDao {

	@Autowired
	private ClientRepository clientRepository;
	
	// insert Client-----------------------------------------------------------------------
	public Client insertClient(Client client) {
		return clientRepository.save(client);
	}
}
