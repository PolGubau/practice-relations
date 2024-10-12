package com.polgubau.udemy.relations.practice_relationcs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.polgubau.udemy.relations.practice_relationcs.entities.Client;
import com.polgubau.udemy.relations.practice_relationcs.entities.Address;
import com.polgubau.udemy.relations.practice_relationcs.entities.Invoice;
import com.polgubau.udemy.relations.practice_relationcs.repositories.ClientRepository;
import com.polgubau.udemy.relations.practice_relationcs.repositories.InvoiceRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class PracticeRelationcsApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(PracticeRelationcsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToOne();
		manyToOneFindByIdClient();
	}

	@Transactional
	public void manyToOne() {
		// new client
		Client client = new Client("John", "Doe");

		// save client
		clientRepository.save(client);

		// new invoice
		Invoice invoice = new Invoice("MacBook Pro", 2000L);

		// set client
		invoice.setClient(client);

		// save invoice
		Invoice invoiceDB = invoiceRepository.save(invoice);

		System.out.println(invoiceDB);
	}

	@Transactional
	public void oneToMany() {

		// find client
		Optional<Client> optionalClient = clientRepository.findById(1L);
		if (!optionalClient.isPresent()) {
			System.out.println("Client not found");
			return;
		}
		Client client = optionalClient.orElseThrow();

		Address address1 = new Address("Street 1", 100);
		Address address2 = new Address("Riera figuera major", 37);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		// save client
		clientRepository.save(client);

	}

	@Transactional
	public void manyToOneFindByIdClient() {

		// find client
		Optional<Client> optionalClient = clientRepository.findById(1L);
		if (!optionalClient.isPresent()) {
			System.out.println("Client not found");
			return;
		}
		Client client = optionalClient.orElseThrow();
		// new invoice
		Invoice invoice = new Invoice("MacBook Pro", 2000L);

		// set client
		invoice.setClient(client);

		// save invoice
		Invoice invoiceDB = invoiceRepository.save(invoice);

		System.out.println(invoiceDB);
	}
}
