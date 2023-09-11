package model.accountF;

import model.ConnDB;

public class BankAccountDAOImpl {
	
	private ConnDB conn;
	
	public BankAccountDAOImpl(ConnDB conn) {
		this.conn = conn;
	}
	
	public void insertBankAccount(String cpf, String type) {
		
	}
}
