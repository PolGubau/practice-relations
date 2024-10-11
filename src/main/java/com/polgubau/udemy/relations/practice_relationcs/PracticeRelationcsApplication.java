package com.polgubau.udemy.relations.practice_relationcs;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.polgubau.udemy.relations.practice_relationcs.entities.Client;
import com.polgubau.udemy.relations.practice_relationcs.entities.Invoice;
import com.polgubau.udemy.relations.practice_relationcs.repositories.ClientRepository;
import com.polgubau.udemy.relations.practice_relationcs.repositories.InvoiceRepository;

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
