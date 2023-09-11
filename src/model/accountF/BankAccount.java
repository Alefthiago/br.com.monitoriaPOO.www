package model.accountF;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Random;

public abstract class BankAccount {
	private Integer number;
	private String type;
	private String cpfOwner;
	private BigDecimal balance;
	private Integer status;

	public BankAccount(String cpfOwner, String type) {
		this.number = new Random().nextInt(999999999);
		this.type = type;
		this.cpfOwner = cpfOwner;
		this.balance = BigDecimal.ZERO;
		this.status = 1;
	}

	public abstract void transaction(BigDecimal value, BankAccount accountDestiny);

	@Override
	public String toString() {
		return "BankAccount [number=" + number + ", type=" + type + ", cpfOwner=" + cpfOwner + ", balance=" + balance
				+ ", status=" + status + "]";
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCpfOwner() {
		return cpfOwner;
	}

	public void setCpfOwner(String cpfOwner) {
		this.cpfOwner = cpfOwner;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, cpfOwner, number, status, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(cpfOwner, other.cpfOwner)
				&& Objects.equals(number, other.number) && Objects.equals(status, other.status)
				&& Objects.equals(type, other.type);
	}
}
