package com.proftelran.org.homework_22.task_2;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerApp {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            String data = "Thread-" + (i + 1);
            executorService.execute(new Worker(exchanger, data));
        }

        executorService.shutdown();
    }
}
