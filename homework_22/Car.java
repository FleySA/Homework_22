package com.proftelran.org.homework_22;

class Car implements Runnable {
    private GasStation gasStation;
    private int carNumber;

    public Car(GasStation gasStation, int carNumber) {
        this.gasStation = gasStation;
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        gasStation.refuel(carNumber);
    }
}