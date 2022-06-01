package com.onetoone.playground;

import java.time.LocalDate;
import java.util.Date;

public class Playground {
    public static void main(String[] args) throws InterruptedException {
        User user1 = new User.UserBuilder("jensen", "alimukti")
                .age(30).phone("081199990000").address("jakarta").build();

        User user2 = new User.UserBuilder("aji", "setiaji")
                .age(20).build();

        User user3 = new User.UserBuilder("alvin", "naufal")
                .address("jakarta").build();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        Date date = new Date();
        System.out.println(date.toString());
    }
}
