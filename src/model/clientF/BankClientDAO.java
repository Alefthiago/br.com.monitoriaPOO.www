package model.clientF;

import java.util.List;

public interface BankClientDAO {
	BankClient checkDataClient(String cpf, String pass);
	BankClient getBankClientByCpf(String clientCpf);
    List<BankClient> getBankClientAll();
    List<String> getClientAllCpf();
    Boolean insertBankClient(BankClient bankClient);
    void updateBankClient(BankClient bankClient);
    void deleteBankClient(BankClient bankClient);
}
