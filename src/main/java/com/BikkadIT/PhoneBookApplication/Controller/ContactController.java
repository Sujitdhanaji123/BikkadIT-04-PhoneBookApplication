package com.BikkadIT.PhoneBookApplication.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.PhoneBookApplication.Entity.Contact;
import com.BikkadIT.PhoneBookApplication.Service.ContactServiceI;


@RestController
public class ContactController {

	@Autowired
	private ContactServiceI contactServiceI;

	@PostMapping(value = "/saveContact", consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact) {

		boolean saveContact = contactServiceI.saveContact(contact);

		if (saveContact) {
			String msg = "Contact Saved Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not Saved Successfully", HttpStatus.CREATED);

		}
	}

	@GetMapping(value = "getAllContact", produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact() {

		List<Contact> allContact = contactServiceI.getAllContact();
		Stream<Contact> stream = allContact.stream();
		Stream<Contact> filter = stream.filter((contact) -> contact.getActiveSwitch() == 'Y');
		List<Contact> list = filter.collect(Collectors.toList());

		return new ResponseEntity<List<Contact>>(list, HttpStatus.OK);

	}

	@GetMapping(value = "/getContactById/{contactId}", produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer contactId) {
		Contact contact = contactServiceI.getContactById(contactId);
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);

	}

	@PutMapping(value = "/updateContact", consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact) {

		boolean saveContact = contactServiceI.updateContact(contact);

		if (saveContact) {
			String msg = "Contact Updated  Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not Updated Successfully", HttpStatus.CREATED);

		}

	}

	@DeleteMapping(value = "/deleteContact/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactId) {
		boolean deleteContact = contactServiceI.deleteContact(contactId);

		if (deleteContact) {
			String msg = "Contact Deleted  Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not Deleted Successfully", HttpStatus.CREATED);

		}

	}

	@DeleteMapping(value = "/deleteContactsoft/{contactId}")
	public ResponseEntity<String> deleteContactSoft(@PathVariable Integer contactId) {
		boolean deleteContact = contactServiceI.deleteConatctSoft(contactId);

		if (deleteContact) {
			String msg = "Contact Deleted  Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Contact not Deleted Successfully", HttpStatus.CREATED);

		}

	}

}
