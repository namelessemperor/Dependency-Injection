package com.sapo.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private Atm bidvAtm;

    @Override
    public void run(String... args) throws Exception {
        Scanner obj = new Scanner(System.in);
        System.out.println("Account No: ");
        String acc = obj.nextLine();
        System.out.println("Pin: ");
        String age = obj.nextLine();
        System.out.println("Money: ");
        BigDecimal money = obj.nextBigDecimal();
        Customer customer = new Customer(acc,age, money);

        //Demo function
//        Atm bidvAtm = new BidvAtm();
        bidvAtm.printCurrentMoney();
        bidvAtm.displayCustomerInfo(customer);
        bidvAtm.withDraw(customer, new BigDecimal(200000));
        bidvAtm.printCurrentMoney();
        bidvAtm.withDraw(customer, new BigDecimal(10000000));
        bidvAtm.printCurrentMoney();
        bidvAtm.deposit(customer,new BigDecimal(1000000));
        bidvAtm.printCurrentMoney();
    }
}
