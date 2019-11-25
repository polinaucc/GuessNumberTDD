package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private static final int RAND_MAX = 100;
    private int unknownNumber;
    private int userNumber;
    private int min;
    private int max;

    List<Integer> attempts;

    public Model() {
        try {
            unknownNumber = rand();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int rand(int... args) throws Exception {
        Random r = new Random();
        if (args.length == 2) {
            this.min = args[0];
            this.max = args[1];
            if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
            }
        } else if (args.length == 0) {
            this.min = 0;
            this.max = com.company.Model.RAND_MAX;
        } else {
            throw new Exception("Illegal args count");
        }
        return r.nextInt((max - min) + 1) + min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public int getUnknownNumber() {
        return unknownNumber;
    }

    public int getUserNumber() {
        return this.userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public void addAttempt(int number) {
        this.attempts.add(number);
    }

    public List<Integer> getAttempts() {
        return this.attempts;
    }
}

