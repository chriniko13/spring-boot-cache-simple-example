package com.chriniko.example.cachetutorial.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
public class TicketService {

    @Cacheable(
            cacheManager = "cacheManager",
            cacheNames = {"tickets"},
            key = "{#root.targetClass , #owner , T(java.util.Arrays).toString(#ticketIds)}" // Note: comment-uncomment to see what happens.
            //key = "{#root.targetClass , #owner , #ticketIds}" // Note: comment-uncomment to see what happens.
    )
    public String save(String owner, Object[] ticketIds) {
        System.out.println("TicketService#save --- method called!");
        return UUID.randomUUID().toString();
    }

    @Cacheable(
            cacheManager = "cacheManager",
            cacheNames = {"tickets"},
            key = "{T(java.lang.String).format('%s-%s', #owner, #ticketIds.toString())}"
    )
    public String save2(String owner, Object[] ticketIds) {
        System.out.println("TicketService#save --- method called!" + Arrays.toString(ticketIds));
        return UUID.randomUUID().toString();
    }

}
