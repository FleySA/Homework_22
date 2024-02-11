package com.proftelran.org.homework_22;

import java.util.Date;
import java.util.Random;

public class GasStationApp {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation(4);
        int durationMinutes = 30;
        Date startTime = new Date();
        Date endTime = new Date(startTime.getTime() + durationMinutes * 60 * 1000);

        while (new Date().before(endTime)) {
            int carNumber = new Random().nextInt(1000) + 1;
            Thread carThread = new Thread(new Car(gasStation, carNumber));
            carThread.start();
            try {
                Thread.sleep(new Random().nextInt(2000) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}