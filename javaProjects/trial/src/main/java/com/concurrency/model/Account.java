package com.concurrency.model;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Account implements Serializable {

    private final String accountNumber;

    private int balance;

    private transient ReadWriteLock balanceLock = new ReentrantReadWriteLock();
    private transient Lock readLock = balanceLock.readLock();
    private transient Lock writeLock = balanceLock.writeLock();
    

    public Account(String accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }
    
    public int getBalance(){       
        readLock.lock();
        int amount;
        try{
        amount = this.balance;
        System.out.println(amount);
        }
        finally{
        readLock.unlock();
        }
        return amount;            
    }

    public void setBalance(int amount){
        writeLock.lock();
        this.balance = amount;
        writeLock.unlock();
    }

    public boolean hasSufficientBalance(int amount){
        return this.getBalance() - amount > 0;
    }

    public boolean equals(Account account){
        return this.accountNumber.equals(account.getAccountNumber());
    }
}
