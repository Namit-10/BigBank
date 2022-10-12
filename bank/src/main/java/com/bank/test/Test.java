package com.bank.test;

import static org.junit.Assert.assertEquals;

import com.bank.dao.BankDao;

class Test {
	
	@org.junit.jupiter.api.Test
	public void deposit() throws Exception {
		assertEquals(1,BankDao.deposit("2520864578945341", 100.00d));
	}
	
	@org.junit.jupiter.api.Test
	public void withdraw() throws Exception {
		assertEquals(1,BankDao.deposit("2520864578945341", 100.00d));
	}
	
	@org.junit.jupiter.api.Test
	public void getAccountNoByUsername() throws Exception {
		assertEquals(null,BankDao.getAccountNoByUsername("RohitSharma"));
	}
	
	@org.junit.jupiter.api.Test
	public void cardExists() throws Exception {
		assertEquals(0,BankDao.cardExists("9999999999999999"));
	}
}	
