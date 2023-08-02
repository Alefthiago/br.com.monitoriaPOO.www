package model.clientF;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.ConnDB;

public class BankClientDAOImpl implements BankClientDAO {

	private ConnDB conn;

	public BankClientDAOImpl(ConnDB conn) {
		this.conn = conn;
	}

	public BankClient getBankClientByCpf(String clientCpf) {

		String sql = "SELECT BC_name, BC_cpf, BC_pass FROM bank_client WHERE BC_cpf = ?";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			stmt = this.conn.getConnection().prepareStatement(sql);
			stmt.setString(1, clientCpf);
			result = stmt.executeQuery();
			if (result.next()) {
				BankClient client = new BankClient(result.getString("BC_cpf"), result.getString("BC_name"),
						result.getString("BC_pass"));
				return client;
			} else {
				return null;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		} finally {
			try {
				stmt.close();
				result.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			this.conn.closeConnection();
		}
	}

	public List<BankClient> getBankClientAll() {

		String sql = "SELECT * FROM bank_client";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<BankClient> clientsList = new ArrayList<>();
		try {
			stmt = this.conn.getConnection().prepareStatement(sql);
			result = stmt.executeQuery();
			while (result.next()) {
				BankClient client = new BankClient(result.getString("BC_cpf"), result.getString("BC_name"),
						result.getString("BC_pass"));
				clientsList.add(client);
			}
			return clientsList;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			this.conn.closeConnection();
		}

	}

	public void insertBankClient(BankClient bankClient) {
		String sql = "INSERT INTO bank_client (BC_cpf, BC_name, BC_pass) VALUES (?, ?, ?)";
		PreparedStatement stmt = null;
		BankClient checkData = getBankClientByCpf(bankClient.getCpf());
		try {
			if (checkData == null) {
				stmt = this.conn.getConnection().prepareStatement(sql);
				stmt.setString(1, bankClient.getCpf());
				stmt.setString(2, bankClient.getName());
				stmt.setString(3, bankClient.getPass());
				stmt.executeUpdate();
			} else {
				JOptionPane.showMessageDialog(null, "Cpf invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			this.conn.closeConnection();
		}

	}

	public List<String> getClientAllCpf() {

		String sql = "SELECT BC_cpf FROM bank_client";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<String> cpfList = new ArrayList<>();
		try {
			stmt = this.conn.getConnection().prepareStatement(sql);
			result = stmt.executeQuery();
			System.out.println(result);
			while (result.next()) {
				cpfList.add((result.getString("BC_cpf")));
			}
			return cpfList;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
			this.conn.closeConnection();
		}
		System.out.println("fiquei confuso");
		return null;
	}

	public void updateBankClient(BankClient bankClient) {

	}

	public void deleteBankClient(BankClient bankClient) {

	}
}
