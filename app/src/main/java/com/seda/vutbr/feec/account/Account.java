package com.seda.vutbr.feec.account;

/**
 * Created by Seda on 3/3/2017.
 */

public class Account {
    private String username;
    private String password;

    public Account(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Account)) return false;
        Account account = (Account) o;

        if (!username.equals(account.username)) return false;
        return password.equals(account.password);

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
