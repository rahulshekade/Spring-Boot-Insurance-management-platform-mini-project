package com.lic.Springbootinsurancemanagementplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lic.Springbootinsurancemanagementplatform.dao.ClientDao;
import com.lic.Springbootinsurancemanagementplatform.dto.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;
	
	// insert Client-----------------------------------------------------------------------
	public Client insertClient(Client client) {
		return clientDao.insertClient(client);
	}	
}
