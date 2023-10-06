package Service;
import Model.Account;
import DAO.AccountDAO;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }
    
    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    
    public Account addAccount(Account account) {
        if(account.getUsername() == "") {
            return null;
        } else if (account.getPassword().length() < 4) {
            return null;
        } else {
            return accountDAO.insertAccount(account);
        } 
    }

    public Account getAccountWhenLogin(Account account) {
        return accountDAO.getAccountLogin(account);
    }
}
