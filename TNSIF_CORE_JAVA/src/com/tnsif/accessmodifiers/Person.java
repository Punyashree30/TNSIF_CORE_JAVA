package com.tnsif.accessmodifiers;

public class Person {

    private int id = 101;

    public String name = "Punyashree";

    protected long phoneNumber = 9113865609L;

    String address = "Mysuru";   // Default access


    public void display() {

        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Phone : " + phoneNumber);
        System.out.println("Address : " + address);

    }
}