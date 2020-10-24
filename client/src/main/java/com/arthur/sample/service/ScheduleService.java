package com.arthur.sample.service;

import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(fixedRate = 1000)
    public void cron() {
	int number = new Random().nextInt();

	if (number % 2 == 1) {
	    dealWithStuff();
	}
    }

    private void dealWithStuff() {
	try {
	    doStuff();
	    doBug();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	    Thread.currentThread().interrupt();
	}
    }

    private void doBug() {
	int number = new Random().nextInt();

	if (number % 2 == 0) {
	    final String emptyString = "";
	    final Long bug = Long.parseLong(emptyString);
	    System.out.println(bug);
	}
    }

    private void doStuff() throws InterruptedException {
	for (int i = 0; i < 5; i++) {
	    System.out.println("...");
	    Thread.sleep(1000);
	}

    }

}
