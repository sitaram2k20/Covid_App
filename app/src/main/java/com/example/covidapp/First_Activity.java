package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class First_Activity<symptom, a> extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button clearButton;
    private Button submitForm;
    private EditText editText;
    private TextView symptomTextview;

    private static final String TAG = "First_Activity";

    // some keys for storing or saving the currentIndex, name , Symptoms[] object
    static final String name = "com.example.Name";
    static final String symptoms = "com.example.Symptoms";
    static final String id = "symptomId";

    private int currentIndex = 0;
    private String prevState = "Initiate First_Activity";  // Assume the state before onCreate in First Activity

    public Symptoms[] symptom = new Symptoms[]{
            new Symptoms(R.string.fever),
            new Symptoms(R.string.ache),
            new Symptoms(R.string.cough),
            new Symptoms(R.string.runny_nose),
            new Symptoms(R.string.scratchy),
            new Symptoms(R.string.smell),
            new Symptoms(R.string.tired),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onCreate");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onCreate", Toast.LENGTH_SHORT).show();
        prevState = "onCreate";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.Edit_Text);
        symptomTextview = (TextView) findViewById(R.id.textView3);
        trueButton = (Button) findViewById(R.id.button);
        falseButton = (Button) findViewById(R.id.button2);
        nextButton = (Button) findViewById(R.id.button3);
        clearButton = (Button) findViewById(R.id.button4);
        submitForm = (Button) findViewById(R.id.button5);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(id);
            editText.setText(savedInstanceState.getString(name));
            symptom = (Symptoms[]) savedInstanceState.get(symptoms);
        }

        symptomTextview.setText(symptom[currentIndex].nameSymptom);   // Set the first symptom on screen

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateSymptom();
            }
        });

        // Clear button clear all the fields and start fresh
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex >= 6 && symptom[currentIndex].getOptionChoice() != 0) {
                    currentIndex = 0;
                    editText.setText("");
                    for (int i = 0; i < symptom.length; i++) {
                        symptom[i].setOptionChoice(0);
                    }
                    symptomTextview.setText(symptom[currentIndex].nameSymptom);
                } else {
                    Toast.makeText(First_Activity.this, "Answer all the symptoms then clear", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // submit button open the second activity.
        submitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().equals("") && currentIndex >= 6 && symptom[currentIndex].getOptionChoice() != 0) {
                    submitButton(view);
                } else {
                    Toast.makeText(First_Activity.this, "Answer all the symptoms and enter the name, then submit", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void submitButton(View view) {
        Intent intent = new Intent(First_Activity.this, Second_Activity.class);  // give intent to switch activity
        intent.putExtra(name, editText.getText().toString());
        intent.putExtra(symptoms, symptom);
        startActivity(intent);
    }

    private void updateSymptom() {
        if (currentIndex < 6 && symptom[currentIndex].getOptionChoice() != 0) {
            symptomTextview.setText(symptom[currentIndex + 1].nameSymptom);
            currentIndex = currentIndex + 1;
        } else if (currentIndex >= 6 && symptom[currentIndex].getOptionChoice() != 0) {
            Toast.makeText(First_Activity.this, "No more Symptoms left. Now you can clear or submit", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(First_Activity.this, "chose Yes or No. Then move to next Symptom", Toast.LENGTH_SHORT).show();
        }
    }

    // check answer is used to store the symptom answer in symptom object
    private void checkAnswer(boolean pressed) {
        if (pressed) {
            symptom[currentIndex].setOptionChoice(1); // 1 == Yes
        } else {
            symptom[currentIndex].setOptionChoice(-1);// -1 == No
        }
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onStart");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onStart", Toast.LENGTH_SHORT).show();
        prevState = "onStart";
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onResume");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onResume", Toast.LENGTH_SHORT).show();
        prevState = "onResume";
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onPause");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onPause", Toast.LENGTH_SHORT).show();
        prevState = "onPause";
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onStop");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onStop", Toast.LENGTH_SHORT).show();
        prevState = "onStop";
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onDestroy");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onDestroy", Toast.LENGTH_SHORT).show();
        prevState = "onDestroy";
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onRestart");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onRestart", Toast.LENGTH_SHORT).show();
        prevState = "onRestart";
        super.onRestart();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onSaveInstanceState");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        prevState = "onSaveInstanceState";
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(name, editText.getText().toString());
        savedInstanceState.putInt(id, currentIndex);
        savedInstanceState.putSerializable(symptoms, symptom);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.i(TAG, "State of First_Activity changed from " + prevState + " to " + "onRestoreInstanceState");
        Toast.makeText(First_Activity.this, "State of First_Activity changed from " + prevState + " to " + "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        prevState = "onRestoreInstanceState";
        super.onRestoreInstanceState(savedInstanceState);
    }
}
