package com.concurrency.service;

import com.concurrency.model.Account;

public class Transactions {
    
    private Account account;

    

    public Transactions(Account account){
        this.account = account;
    }

    public int getBalance(){
       return this.account.getBalance();
    }

    public void debit(int amount) throws RuntimeException{
        synchronized (account) {
            int currentAmount = this.account.getBalance();
        if (currentAmount > amount){
            currentAmount -= amount;
        }
        else{
            System.out.println("Operation not possible");
            return;
        }
        this.account.setBalance(currentAmount);
    }
        this.account.getBalance();
    }

    public void credit(int amount){
       synchronized(account) {
        int currentAmount = this.account.getBalance();
        currentAmount += amount;
        this.account.setBalance(currentAmount);
       }
       this.account.getBalance();
    }
}
