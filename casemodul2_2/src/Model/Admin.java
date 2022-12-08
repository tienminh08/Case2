package Model;

import java.io.Serializable;

public class Admin implements Serializable {
    private String AccountName;
    private String Password;

    public Admin() {
    }

    public Admin(String accountName, String password) {
        AccountName = accountName;
        Password = password;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return
                "AccountName='" + AccountName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
