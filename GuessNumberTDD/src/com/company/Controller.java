package com.company;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner input;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.input = new Scanner(System.in);
    }

    public int inputTheNumber(){
        this.view.printInputString();
        if(!this.input.hasNextInt()) {
            this.view.printIncorrectNumberError(this.input.next());
            return this.inputTheNumber();
        }
        int userNumber = this.input.nextInt();
        return userNumber;
    }

    public boolean correctData(int userNumber) {
        if(userNumber <= this.model.getMin() || userNumber >= this.model.getMax() ) {
            this.view.printIncorrectRangeError();
            this.view.printStartedString(this.model.getMin(), this.model.getMax());
            return false;
        }

        return true;
    }

    public boolean isSmaller(int userNumber, int unknownNumber) {
        if (userNumber > unknownNumber){
            this.view.printSmaller();
            this.model.setMax(userNumber);
            return true;
        } else return false;
    }

    public boolean isBigger(int userNumber, int unknownNumber) {
        if (userNumber < unknownNumber){
            this.view.printBigger();
            this.model.setMin(userNumber);
            return true;
        } else return false;
    }

    public boolean isEqual(int userNumber, int unknownNumber) {
        if (userNumber == unknownNumber){
            this.view.printSuccess();
            return true;
        } else return false;
    }

    public void startGame() {
        boolean isEqual = false;
        this.view.printStartedString(this.model.getMin(), this.model.getMax());
        do {
            this.view.printAttempts(this.model.getAttempts());
            int userNumber = inputTheNumber();
            this.model.setUserNumber(userNumber);
            int unknownNumber = this.model.getUnknownNumber();
            if(!correctData(userNumber)) continue;
            if((!isSmaller(userNumber, unknownNumber))&&(!isBigger(userNumber,unknownNumber)))
                isEqual = isEqual(userNumber,unknownNumber);
            else this.model.addAttempt(userNumber);
        } while (!isEqual);
    }
}
