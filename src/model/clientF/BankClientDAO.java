package model.clientF;

import java.util.List;

public interface BankClientDAO {
    BankClient getBankClientByCpf(BankClient bankClient);
    List<BankClient> getBankClientAll();
    void insertBankClient(BankClient bankClient);
    void updateBankClient(BankClient bankClient);
    void deleteBankClient(BankClient bankClient);
}
