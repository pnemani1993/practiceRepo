package com.concurrency.utils;

public class Tasks implements Runnable {

    private String name;

    public Tasks(String name){
        this.name = name;
    }

    public void run(){
        System.out.println(this.name + " has started execution.");
        try{
        Thread.sleep((long)(Math.random()*5000)%1);
        }
        catch(InterruptedException ex){
            System.out.println(this.name + " has caused " +  ex.getMessage());
        }

        System.out.println(this.name + " has completed execution");

    }
    
}
