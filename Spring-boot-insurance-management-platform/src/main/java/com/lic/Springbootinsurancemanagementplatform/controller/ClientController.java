package com.lic.Springbootinsurancemanagementplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lic.Springbootinsurancemanagementplatform.dto.Client;
import com.lic.Springbootinsurancemanagementplatform.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	// insert Client-----------------------------------------------------------------------
	@PostMapping("/saveClient")
	public Client insertClient(@RequestBody Client client) {
		return clientService.insertClient(client);
	}	
}
