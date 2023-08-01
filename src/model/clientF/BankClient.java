package model.clientF;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.accountF.BankAccount;

public class BankClient {

	private String cpf;
	private String name;
	private String pass;
	private List<BankAccount> accounts;

	public BankClient(String cpf, String name, String pass) {
		this.cpf = cpf;
		this.name = name;
		this.pass = pass;
		this.accounts = new ArrayList<BankAccount>();
	}

	@Override
	public String toString() {
		return "BankClient [cpf=" + this.cpf + ", name=" + this.name + ", pass=" + this.pass + ", accounts="
				+ this.accounts + "]";
	}

	public void addAccount(BankAccount account) {
		if (this.accounts.contains(account)) {
			System.out.println("Conta já existente!");
		} else {
			for (BankAccount existingAccount : this.accounts) {
				if (existingAccount.getType().equals(account.getType())) {
					System.out.println("Não é possivel ter duas contas do mesmo tipo!");
					return;
				}
			}
			this.accounts.add(account);
			System.out.println("Conta adicionada.");
		}
	}

	public void deleteAccount(BankAccount account) {
		if (account.getBalance().compareTo(BigDecimal.ZERO) > 0) {
			System.out.println("A conta possui saldo e não pode ser excluída!");
		} else {
			System.out.println("A conta foi excluida.");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, name, pass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankClient other = (BankClient) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(name, other.name) && Objects.equals(pass, other.pass);
	}

}
