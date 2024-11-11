package com.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Properties;

import com.concurrency.model.Account;
import com.concurrency.service.Transactions;
import com.concurrency.utils.Tasks;

public class Main {
    public static void main(String[] args) throws IOException {

            Thread th1 = new Thread(new Tasks("First Tasks"));
            Thread th2 = new Thread(new Tasks("Second Tasks"));
            Thread th3 = new Thread(new Tasks("Third Tasks"));

            th1.start();
            th2.start();
            th3.start();
            try {
                System.out.println("no error");
                th1.join();
                th2.join();
                th3.join();
            }
            System.out.println("End of the main function");

    }

    public static void accountTesting(){
        
        Account account = new Account(500);
        Transactions newTr = new Transactions(account);

        Thread firstThread = new Thread(()-> newTr.credit(1000));

        Thread secondThread = new Thread(()-> newTr.debit(1300));

        firstThread.start();
        secondThread.start();
    }

    public static void runningCommands() throws Exception{
        
        Properties props = new Properties();
        props.setProperty("Name.FirstName", "Pardhu");
        props.setProperty("Name.LastName", "Nemani");
        props.entrySet().forEach((k)-> System.out.println(k));
        System.out.println("All System Properties:");
        Arrays.stream(System.getProperties().toString().split(",")).forEach(e -> System.out.println(e));
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Available Processors: " + runtime.availableProcessors());
        System.out.println("Free Memory: " + runtime.freeMemory());
        // System.out.println(runtime.exit(status));

        try{    

        ProcessBuilder pb = new ProcessBuilder("Powershell.exe", "-Command", "Get-ChildItem", "'E:\\'");

        System.out.println("Environment from ProcessBuilder: \n" + pb.environment());
        
        // System.out.println(pb.directory().toString());

        Process newProcess = pb.start();

        BufferedReader bfr = new BufferedReader(new InputStreamReader(newProcess.getInputStream()));
        System.out.println("Output of the command: ");
        String line;
        while((line = bfr.readLine()) != null){
            System.out.println(line);
        }

        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}