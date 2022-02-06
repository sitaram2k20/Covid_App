package com.example.covidapp;

import java.io.Serializable;

// implement model in which I make the class Serializable which helps us to save the instance and pass intent
public class Symptoms implements Serializable {
    public int nameSymptom;
    private int optionChoice = 0; // initially it is 0 which means Symptom has no answer, Later we set value 1==Yes and -1==No according to user choice

    public Symptoms(int symptom){
        nameSymptom = symptom;
    }

    public int getOptionChoice() {
        return optionChoice;
    }

    public void setOptionChoice(int option){
        optionChoice = option;
    }
}
