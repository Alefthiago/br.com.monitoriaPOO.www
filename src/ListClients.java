import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.ConnDB;
import model.clientF.BankClient;
import model.clientF.BankClientDAO;
import model.clientF.BankClientDAOImpl;

public class ListClients extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListClients frame = new ListClients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListClients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBack = new JButton("Voltar");
		btnBack.setBounds(506, 379, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);

		List<String> cpfList = new ArrayList<>();
		BankClientDAO getList = new BankClientDAOImpl(new ConnDB());
		cpfList = getList.getClientAllCpf();
		DefaultListModel<String> dataList = new DefaultListModel<>();

		for (String cpf : cpfList) {
			dataList.addElement(cpf);
		}

		JList<String> list = new JList<>(dataList);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(5, 51, 120, 354);
		contentPane.add(scrollPane);

		txtSearch = new JTextField();
		txtSearch.setBounds(63, 16, 106, 20);
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				filterList();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				filterList();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filterList();
			}
		});
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(135, 51, 64, 29);
		contentPane.add(lblNewLabel);

		JLabel lblCpf = new JLabel("Cpf :");
		lblCpf.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblCpf.setBounds(135, 91, 45, 29);
		contentPane.add(lblCpf);

		JLabel lblContas = new JLabel("Conta poupança:");
		lblContas.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblContas.setBounds(135, 131, 147, 29);
		contentPane.add(lblContas);

		JLabel lblContaCorrente = new JLabel("Conta corrente:");
		lblContaCorrente.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblContaCorrente.setBounds(135, 171, 137, 29);
		contentPane.add(lblContaCorrente);

		JLabel lblClienteDesde = new JLabel("Cliente desde ");
		lblClienteDesde.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblClienteDesde.setBounds(154, 380, 120, 29);
		contentPane.add(lblClienteDesde);

		JLabel lblClientAccountC = new JLabel("");
		lblClientAccountC.setFont(new Font("Arial", Font.PLAIN, 15));
		lblClientAccountC.setBounds(282, 176, 386, 21);
		contentPane.add(lblClientAccountC);

		JLabel lblClientAccountS = new JLabel("");
		lblClientAccountS.setFont(new Font("Arial", Font.PLAIN, 15));
		lblClientAccountS.setBounds(292, 136, 386, 21);
		contentPane.add(lblClientAccountS);

		JLabel lblClientName = new JLabel("");
		lblClientName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblClientName.setBounds(209, 56, 307, 21);
		contentPane.add(lblClientName);

		JLabel lblClientCpf = new JLabel("");
		lblClientCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		lblClientCpf.setBounds(190, 96, 307, 21);
		contentPane.add(lblClientCpf);

		JLabel lblClientName_1_1_1_1 = new JLabel("");
		lblClientName_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblClientName_1_1_1_1.setBounds(277, 385, 158, 21);
		contentPane.add(lblClientName_1_1_1_1);

		JLabel lblNome = new JLabel("Nome  :");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNome.setBounds(5, 11, 64, 29);
		contentPane.add(lblNome);

		setResizable(false);
		setLocationRelativeTo(null);
	
		list.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) { // Verifica se é uma seleção real, não uma mudança temporária
				int i = list.getSelectedIndex();
				String selectCpf = dataList.get(i);
				BankClientDAO getDataClient = new BankClientDAOImpl(new ConnDB());
				BankClient selectClient = getDataClient.getBankClientByCpf(selectCpf);
				lblClientName.setText(selectClient.getName());
				lblClientCpf.setText(selectClient.getCpf());
			}
		});
	}

	void filterList() {

	};
};
