package com.example.covidapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Second_Activity extends AppCompatActivity {

    private int index = 0; // counter for Yes symptoms
    private Button resultButton;
    private TextView resultTextView;
    private TextView fillSymptoms; // Title for Second Activity

    private String previousState = "Switches Second_Activity from First_Activity";

    private static final String tag= "Second_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onCreate");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onCreate",Toast.LENGTH_SHORT).show();
        previousState = "onCreate";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        resultTextView =(TextView)findViewById(R.id.textView4);
        fillSymptoms =(TextView)findViewById(R.id.textView5);
        resultButton = (Button)findViewById(R.id.button6);

        // Get the intent from first Activity i.e name saved and Symptom[] object
        Intent intent = getIntent();
        String idName = intent.getStringExtra(First_Activity.name);

        Bundle b=this.getIntent().getExtras();  // get symptom object using bundle
        Symptoms[] symptomRecord = (Symptoms[]) b.get(First_Activity.symptoms);

        fillSymptoms.setText(idName.toString() + "'s Symptoms");

        ListView myList = (ListView) findViewById(R.id.myList);  // Use list view to store the filled symptoms
        ArrayList<String> filled_symptoms = new ArrayList<>();

        if(savedInstanceState!=null){
            resultTextView.setText(savedInstanceState.getString("result"));
        }

        for(int i=0;i<=6;i++){
            if (symptomRecord[i].getOptionChoice() == 1){
                index = index + 1;
                filled_symptoms.add(getString(symptomRecord[i].nameSymptom) + "  :  " + "True");
            }
            else{
                filled_symptoms.add(getString(symptomRecord[i].nameSymptom) + "  :  " + "False");
            }

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(Second_Activity.this, android.R.layout.simple_expandable_list_item_1,filled_symptoms);
        myList.setAdapter(arrayAdapter);


        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 3){
                    resultTextView.setText(idName.toString() + " should get tested.");
                }
                else{
                    //Toast.makeText(Second_Activity.this, Integer.toString(index),Toast.LENGTH_SHORT).show();
                    resultTextView.setText(idName.toString() + " shouldn't get tested.");
                }

            }
        });
    }
    @Override
    protected void onStart() {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onStart");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onStart",Toast.LENGTH_SHORT).show();
        previousState = "onStart";
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onResume");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onResume",Toast.LENGTH_SHORT).show();
        previousState = "onResume";
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onPause");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onPause",Toast.LENGTH_SHORT).show();
        previousState = "onPause";
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onStop");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onStop",Toast.LENGTH_SHORT).show();
        previousState = "onStop";
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onDestroy");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onDestroy",Toast.LENGTH_SHORT).show();
        previousState = "onDestroy";
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onRestart");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onRestart",Toast.LENGTH_SHORT).show();
        previousState = "onRestart";
        super.onRestart();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onSaveInstanceState");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onSaveInstanceState",Toast.LENGTH_SHORT).show();
        previousState = "onSaveInstanceState";
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("result",resultTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.i(tag,"State of Second_Activity changed from " + previousState+ " to "+ "onRestoreInstanceState");
        Toast.makeText(Second_Activity.this,"State of Second_Activity changed from " + previousState+ " to "+ "onRestoreInstanceState",Toast.LENGTH_SHORT).show();
        previousState = "onRestoreInstanceState";
        super.onRestoreInstanceState(savedInstanceState);
    }
}