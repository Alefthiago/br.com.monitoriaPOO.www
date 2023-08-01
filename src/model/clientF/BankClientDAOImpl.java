package model.clientF;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import model.ConnDB;


public class BankClientDAOImpl implements BankClientDAO {

	private ConnDB conn;
	
    public BankClientDAOImpl(ConnDB conn) {
    	this.conn = conn;
    }

    public BankClient getBankClientByCpf(BankClient bankClient) {
		return null;
    }

    public void insertBankClient(BankClient bankClient) {
        String sql = "INSERT INTO bank_client (BC_cpf, BC_name, BC_pass) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;
        
        try {
        	stmt = this.conn.getConnection().prepareStatement(sql);
        	stmt.setString(1, bankClient.getCpf());
        	stmt.setString(2, bankClient.getName());
        	stmt.setString(3, bankClient.getPass());
        	stmt.executeUpdate();
        	
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<BankClient> getBankClientAll() {
    	return null;
    }

    public void updateBankClient(BankClient bankClient) {
        
    }

    public void deleteBankClient(BankClient bankClient) {
        
    }
}
