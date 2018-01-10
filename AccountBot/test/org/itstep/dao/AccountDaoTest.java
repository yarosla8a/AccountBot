package org.itstep.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.itstep.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountDaoTest {

	private String firstName;
	private String secondName;

	@Before
	public void setDataBeforeTest() {
		firstName = "Abcdefg";
		secondName = "Qwertyui";
		AccountDao accDao = new AccountDao();
		Account account = new Account(firstName, secondName);
		accDao.save(account);
	}

	@After
	public void deleteDataAfterTest() {
		AccountDao accDao = new AccountDao();
		accDao.delete(firstName, secondName);
	}

	@Test
	public void testUpdate() {

		AccountDao accDao = new AccountDao();

		assertNotNull(accDao.get(firstName, secondName).getEmail());

		Account updatedAccount = new Account();
		updatedAccount.setFirstName("Poiuytr");
		updatedAccount.setSecondName("Zxcvbnm");
		updatedAccount.setEmail("Poiuytr@ukr.net");
		updatedAccount.setPassword("123456789");

		accDao.update(firstName, secondName, updatedAccount);

		assertNull(accDao.get(firstName, secondName).getEmail());

		firstName = updatedAccount.getFirstName();
		secondName = updatedAccount.getSecondName();

		assertEquals(accDao.get(firstName, secondName).getEmail(), "Poiuytr@ukr.net");

	}
	@Test 
	public void testSave() {
		
	}
	
}