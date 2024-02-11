package com.proftelran.org.homework_22;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class GasStation {
    private Semaphore pumps;

    public GasStation(int numPumps) {
        pumps = new Semaphore(numPumps);
    }

    public void refuel(int car) {
        try {
            pumps.acquire();
            System.out.println("Car " + car + " is refueling at pump " + Thread.currentThread().getName());
            int refuelTime = new Random().nextInt(4) + 3; // Simulate refueling time between 3 to 6 seconds
            Thread.sleep(refuelTime * 1000); // Convert seconds to milliseconds
            System.out.println("Car " + car + " has finished refueling");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pumps.release();
        }
    }
}


