package com.BikkadIT.PhoneBookApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.PhoneBookApplication.Entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
