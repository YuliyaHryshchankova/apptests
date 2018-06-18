package com.company.test.staticfactory;

import com.company.test.businessobjects.Nomination;

import java.util.Random;

public class NominationStaticFactory {

    private static Random rand = new Random();

    public static Nomination createDefaultNomination() {
        Nomination nomination = new Nomination();
        nomination.setAwardMessage("test message" + String.valueOf(rand.nextInt(999)));
        nomination.setAwardTitle("test title" + String.valueOf(rand.nextInt(999)));
        return nomination;
    }
}
