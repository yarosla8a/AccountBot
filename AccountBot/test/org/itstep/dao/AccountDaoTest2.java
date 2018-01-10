package org.itstep.dao;

import static org.junit.Assert.*;

import org.itstep.model.Account;
import org.junit.Test;

public class AccountDaoTest2 {
	private String firstName;
	private String secondName;

	@Test
	public void testSave() {
		AccountDao accDao = new AccountDao();
		
		Account saveAccount = new Account();
		saveAccount.setFirstName("yara");
		saveAccount.setSecondName("pi");
		saveAccount.setEmail("tgh45@gmail.com");
		saveAccount.setPassword("1111");
		
		accDao.save(saveAccount);
	}

	@Test
	public void testGet() {
		AccountDao accDao = new AccountDao();
		
		
		Account getAccount = new Account();
		getAccount.setFirstName("yara");
		getAccount.setSecondName("pi");
		
		accDao.get(firstName, secondName);
		
		
	}

	@Test
	public void testUpdate() {
		//done in AccountDaoTest class;
	}

	@Test
	public void testDelete() {
		AccountDao accDao = new AccountDao();
		
		
		Account deleteAccount = new Account();
		deleteAccount.setFirstName("yara");
		deleteAccount.setSecondName("pi");
		
		accDao.delete(firstName, secondName);
		
		
			
		
	}

}
