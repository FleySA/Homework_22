package com.proftelran.org.homework_22.task_2;

import java.util.concurrent.Exchanger;

public class Worker implements Runnable {
    private Exchanger<String> exchanger;
    private String data;

    public Worker(Exchanger<String> exchanger, String data) {
        this.exchanger = exchanger;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " data before exchange: " + data);
            // Wait for other thread to arrive at the exchange point
            data = exchanger.exchange(data);
            System.out.println("Thread " + Thread.currentThread().getName() + " data after exchange: " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}