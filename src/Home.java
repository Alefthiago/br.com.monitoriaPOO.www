import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.accountF.BankAccount;
import model.clientF.BankClient;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	BankClient user;
// 	teste gitKraken
//	/** lembrar de falar com o professor sobre essa parte do codigo gerada automaticamente
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Home frame = new Home();
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
	public Home(BankClient user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vinde " + this.user.getName());
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 585, 29);
		contentPane.add(lblNewLabel);
		
		
		JButton btnCreateAccountS = new JButton("Criar conta");
		btnCreateAccountS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Perguntar para o professor porque é repciso usar chamar o obejto "Home" neste caso.
				BankAccount newAccountS = new BankAccount(Home.this.user.getCpf(), "poupança");
				Home.this.user.addAccount(newAccountS);
				System.out.println(Home.this.user);
			}
		});
		btnCreateAccountS.setBounds(60, 252, 89, 23);
		contentPane.add(btnCreateAccountS);
		
		JLabel lblNewLabel_1 = new JLabel("Conta poupança:");
		lblNewLabel_1.setBounds(60, 178, 215, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCreateAccountC = new JButton("Criar conta");
		btnCreateAccountC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankAccount newAccountC = new BankAccount(Home.this.user.getCpf(), "corrente");
				Home.this.user.addAccount(newAccountC);
				System.out.println(Home.this.user);
			}
		});
		btnCreateAccountC.setBounds(380, 252, 89, 23);
		contentPane.add(btnCreateAccountC);
		
		JLabel lblNewLabel_1_1 = new JLabel("Conta corrente:");
		lblNewLabel_1_1.setBounds(380, 178, 215, 29);
		contentPane.add(lblNewLabel_1_1);
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
