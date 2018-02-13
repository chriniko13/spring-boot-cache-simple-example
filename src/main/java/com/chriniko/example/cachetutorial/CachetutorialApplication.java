package com.chriniko.example.cachetutorial;

import com.chriniko.example.cachetutorial.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.management.ManagementFactory;

@SpringBootApplication
public class CachetutorialApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CachetutorialApplication.class, args);
    }


    @Autowired
    private TicketService ticketService;

    @Override
    public void run(String... strings) {

        String javaIdProcess = ManagementFactory.getRuntimeMXBean().getName();

        // --- 1st example ---
        System.out.println("~~~1st example ~~~");

        Object[] ticketIds = {1, "abc", 3.0F};
        String result1 = ticketService.save(javaIdProcess, ticketIds);
        System.out.println("result1 = " + result1 + "\n");

        foo(javaIdProcess, new Object[]{1, "abc", 3.0F});

        String result3 = ticketService.save(javaIdProcess, new Object[]{1, "abc", 4.0F});
        System.out.println("result3 = " + result3 + "\n");


        // --- 2nd example ---
        System.out.println("\n~~~2nd example~~~");
        ticketService.save2(javaIdProcess, ticketIds);
        ticketService.save2(javaIdProcess, ticketIds);
        ticketService.save2(javaIdProcess, new Object[]{"a"});


        System.out.println("\n");
    }

    private void foo(String javaIdProcess, Object[] ticketIds) {
        String result2 = ticketService.save(javaIdProcess, ticketIds);
        System.out.println("result2 = " + result2 + "\n");
    }
}
