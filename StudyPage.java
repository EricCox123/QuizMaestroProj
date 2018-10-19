package com.example.eric.quizmaestro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import com.example.eric.quizmaestro.R;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudyPage extends AppCompatActivity {

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;
    Toolbar toolbar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studypage);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner = (Spinner) findViewById(R.id.static_spinner);

        toolbar.setTitle(getResources().getString(R.string.app_name));

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(StudyPage.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.Menu));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selection = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), selection, Toast.LENGTH_SHORT);
                if(selection.equals("Decks"))
                {
                    Intent intentLog = new Intent (StudyPage.this,DeckPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Home"))
                {
                    Intent intentLog = new Intent (StudyPage.this,MainActivity.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Study"))
                {

                }
                if(selection.equals("Help"))
                {
                    Intent intentLog = new Intent (StudyPage.this,HelpPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        al = new ArrayList<>();
        al.add("Question appears here");
        al.add("Click to reveal answer");

        String qq;



        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al );

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(StudyPage.this, "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(StudyPage.this, "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(StudyPage.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void addCards(DeckPage.Deck name, ArrayList<String> cards){
        cards.add(name.deckCards[1].question);
        cards.add(name.deckCards[2].answer);

    }
}