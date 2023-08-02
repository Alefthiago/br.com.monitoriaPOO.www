package model.clientF;

import java.util.List;

public interface BankClientDAO {
    BankClient getBankClientByCpf(String clientCpf);
    List<BankClient> getBankClientAll();
    List<String> getClientAllCpf();
    void insertBankClient(BankClient bankClient);
    void updateBankClient(BankClient bankClient);
    void deleteBankClient(BankClient bankClient);
}
