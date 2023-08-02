import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.ConnDB;
import model.clientF.BankClient;
import model.clientF.BankClientDAO;
import model.clientF.BankClientDAOImpl;

public class Registration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCpf;
	private JPasswordField txtPass;

//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Registration frame = new Registration();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Voltar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 379, 89, 23);
		contentPane.add(btnBack);

		txtName = new JTextField();
		txtName.setBounds(227, 132, 130, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(227, 179, 130, 20);
		contentPane.add(txtCpf);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(139, 135, 58, 17);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Cpf :");
		lblSenha.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSenha.setBounds(159, 179, 58, 17);
		contentPane.add(lblSenha);

		JLabel lblSenha_1 = new JLabel("Senha :");
		lblSenha_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSenha_1.setBounds(139, 229, 78, 17);
		contentPane.add(lblSenha_1);

		txtPass = new JPasswordField();
		txtPass.setBounds(227, 229, 130, 20);
		contentPane.add(txtPass);

		JLabel lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(227, 55, 158, 29);
		contentPane.add(lblNewLabel_1);

		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String cpf = txtCpf.getText();
				char[] pass = txtPass.getPassword();
				String passString = (new String(pass));
				if (!name.isEmpty() && !cpf.isEmpty() && !passString.isEmpty()) {
					try {
						MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
						byte messageDigest[] = algorithm.digest(passString.getBytes("UTF-8"));
						StringBuilder hexString = new StringBuilder();
						for (byte b : messageDigest) {
							hexString.append(String.format("%02X", 0xFF & b));
						}
						String hashPass = hexString.toString();
						BankClient newClient = new BankClient(cpf, name, hashPass);
						BankClientDAO bankClientDAO = new BankClientDAOImpl(new ConnDB());

						if (bankClientDAO.insertBankClient(newClient)) {
							Home homeFrame = new Home(newClient);
							homeFrame.setVisible(true);
							dispose();
						}
					} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCriar.setBounds(248, 277, 89, 23);
		contentPane.add(btnCriar);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
