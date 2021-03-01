/*
 * Copyright 2019-Current jittagornp.me
 */
package me.jittagornp.example.generics;


/**
 * Reference https://pramothsuwanpech.medium.com/variance-%E0%B8%81%E0%B8%B1%E0%B8%9A-java-generics-b259e73b79e5
 *
 * @author jitta
 */

public class JavaGenerics {

    public static class Vehicle { }

    public static class Car extends Vehicle{ }

    public static class Truck extends Car{ }

    public static class Container<T> { }

    public static void main(final String[] args) {
        invariance();
        covariance();
        contravariance();
    }

    private static void invariance(){
        Container<Car> container;
        container = new Container<Vehicle>(); //Compile Error
        container = new Container<Car>();//OK
        container = new Container<Truck>(); //Compile error
    }

    private static void covariance(){
        Container<? extends Car> container;
        container = new Container<Vehicle>();// Compile Error
        container = new Container<Car>(); // OK
        container = new Container<Truck>(); // OK
    }

    private static void contravariance(){
        Container<? super Car> container;
        container = new Container<Vehicle>();// OK
        container = new Container<Car>();// OK
        container = new Container<Truck>();// Compile Error
    }

}
