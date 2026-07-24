package com.tnsif.accessmodifiers;

public class Executor {

    public static void main(String[] args) {

        Person p = new Person();

        // Private variable cannot be accessed directly
        // System.out.println(p.id);

        System.out.println("Name : " + p.name);
        System.out.println("Phone : " + p.phoneNumber);
        System.out.println("Address : " + p.address);

        p.display();

    }
}