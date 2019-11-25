package com.company;

import javax.xml.stream.events.DTD;
import java.util.List;
import java.util.stream.Collectors;

public class View {

    public static final String INVITATION_MESSAGE = "\u001B[31mYou should guess the number in range ";
    public static final String BIGGER = "My number is bigger. ";
    public static final String SMALLER = "My number is smaller. ";
    public static final String INVITATION = "Enter your number: ";
    public static final String GUESSED = "You guessed";
    public static final String ATTEMPTS = "Your attempts: ";
    public static final String RANGE_ERR = "Incorrect range";
    public static final String NOT_NUMBER = "It is not number: ";

    public void printStartedString(int min, int max) {
        System.out.println(INVITATION_MESSAGE + "(" + min + " ; " + max + ")" + "\u001B[0m");
    }
    public void printBigger() {
        System.out.print(BIGGER);
    }
    public void printSmaller() {
        System.out.print(SMALLER);
    }
    public void printInputString() {
        System.out.print(INVITATION);
    }
    public void printSuccess() {
        System.out.println(GUESSED);
    }
    public void printAttempts(List<Integer> attempts) {
        if(attempts.size() == 0) return;
        String attemptStr = attempts.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(ATTEMPTS + attemptStr);
    }
    public void printStats(List<Integer> attempts) {
        System.out.println("You made " + attempts.size() + " attempts");
        this.printAttempts(attempts);
    }

    public void printIncorrectRangeError() {
        System.out.println(RANGE_ERR);
    }

    public void printIncorrectNumberError(String string) {
        System.out.println(NOT_NUMBER + string);
    }
}
