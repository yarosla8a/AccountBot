package org.itstep.dao;

import static org.junit.Assert.*;

import org.itstep.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountDaoTest2 {

	private String firstName;
	private String secondName;


	@Before
	public void setDataBeforeTest() {
		firstName = "Aaaa";
		secondName = "Qqqq";

	}
	@After
	public void deleteDataAfterTest() {
		AccountDAO accDao = new AccountDAO();
		accDao.delete(firstName, secondName);
	}

	@Test
	public void testSave() {
		AccountDAO accDao = new AccountDAO();

		Account account = new Account(firstName, secondName);

		account.setEmail("tgh45@gmail.com");
		account.setPassword("1111");

		accDao.save(account);

		assertNotNull(accDao.get(firstName, secondName).getEmail());
	}

	@Test
	public void testGet() {
		AccountDAO accDao = new AccountDAO();

		accDao.get(firstName, secondName);
		assertNotNull(accDao.get(firstName, secondName));

	}

	@Test
	public void testUpdate() {
		AccountDAO accDao = new AccountDAO();

		Account updatedAccount = new Account();
		updatedAccount.setFirstName("Poiuytr");
		updatedAccount.setSecondName("Zxcvbnm");
		updatedAccount.setEmail("Poiuytr@ukr.net");
		updatedAccount.setPassword("123456789");

		accDao.update(firstName, secondName, updatedAccount);

		assertNull(accDao.get(firstName, secondName).getEmail());

		firstName = updatedAccount.getFirstName();
		secondName = updatedAccount.getSecondName();

	//	assertNotNull(accDao.get(firstName, secondName).getEmail());
		 assertEquals("Poiuytr@ukr.net", updatedAccount.getEmail());
	}

	@Test
	public void testDelete() {
		AccountDAO accDao = new AccountDAO();

		assertNotNull(accDao.get(firstName, secondName).getEmail());

		accDao.delete(firstName, secondName);

		assertNull(accDao.get(firstName, secondName).getEmail());

	}

}
