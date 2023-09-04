package model.accountF;

import java.math.BigDecimal;

public class BankAccountS extends BankAccount {

	public BankAccountS(String cpfOwner, String type) {
		super(cpfOwner, type);
	}

	@Override
	public void transaction(BigDecimal value, BankAccount accountDestiny) {
		if (accountDestiny.getStatus() == 1) {
			if (this.getBalance().compareTo(BigDecimal.ZERO) > 0) {
				if (this.getBalance().compareTo(value) >= 0) {
					
				} else {

				}
			} else {

			}
		} else {

		}

	}
}
