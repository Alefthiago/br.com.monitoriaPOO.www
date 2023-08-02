import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpf;
	private JPasswordField txtPass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo!");
		lblNewLabel.setBounds(251, 35, 156, 29);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(256, 104, 119, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setBounds(271, 203, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("CPF :");
		lblNewLabel_1.setBounds(200, 105, 46, 14);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha :");
		lblNewLabel_1_1.setBounds(185, 154, 61, 14);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnListClients = new JButton("Entrar");
		btnListClients.setBounds(20, 379, 89, 23);
		btnListClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListClients listClientsFrame = new ListClients();
				listClientsFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnListClients);
		
		JLabel lblNewLabel_1_2 = new JLabel("Consultar  CPF:");
		lblNewLabel_1_2.setBounds(10, 339, 133, 29);
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnRegistration = new JButton("Cadastro");
		btnRegistration.setBounds(271, 244, 89, 23);
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration registrationFrame = new Registration();
				registrationFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRegistration);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(256, 153, 119, 20);
		contentPane.add(txtPass);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
