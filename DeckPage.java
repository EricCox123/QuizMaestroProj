package com.example.eric.quizmaestro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DeckPage extends AppCompatActivity {

    private Button addDeck;
    Toolbar toolbar;
    Spinner spinner;
    public ListView deckList;
    private int i = 0;

     static public class Deck {
        Card[] deckCards = new Card[10];   //ended here.

        String deckName;
        //have seperate card class, object

        //constructor
        public Deck(String name) {
            this.deckName = name;
        }

        public String getName() {
            return deckName;
        }
        public void setDeckName(String name){
            this.deckName = name;
        }
    }
     static public class Card {
        String cardID;
        String question;
        String answer;
        //have seperate card class, object

        //constructor
        public Card(String cardID ,String quest, String ans) {
            this.cardID = cardID;
            this.question = quest;
            this.answer = ans;
        }
        public String getCardID() {
            return cardID;
        }
        public void setCardID(String Q){
            this.cardID = Q;
        }
        public String getQuestion() {
            return question;
        }
        public void setQuestion(String Q){
            this.question = Q;
        }
        public String getAnswer() {
            return answer;
        }
        public void setAnswer(String A){
            this.question = A;
        }
    }

    static int cardCounter = 0;

    static public void addCardToDeck(Deck targetDeck, Card curCard, Context context){
        if(cardCounter >= 10){
            Toast ifx = Toast.makeText(context, "Deck limit reached.", Toast.LENGTH_SHORT);

            //Toast.makeText(DeckPage.this, "Deck limit reached", Toast.LENGTH_SHORT).show();
        }else {
            targetDeck.deckCards[cardCounter] = curCard;
            cardCounter++;
        }
    }


    public void newDeck(View view) {

        EditText dName = (EditText)findViewById(R.id.newDeckName);
        String mName = dName.getText().toString();
        Deck newDeck = new Deck(mName);
        allDecks[3] = newDeck;
        //i++;
        Toast.makeText(DeckPage.this,
                "Deck: " + mName + " Created!",
                Toast.LENGTH_LONG).show();

        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    public static Deck[] allDecks = {new Deck("Science!"), new Deck("Math"), new Deck("Girlfriend"),
    new Deck("Empty Deck")};

    String one = allDecks[0].getName();
    String two = allDecks[1].getName();
    String three = allDecks[2].getName();
    //String ok = allDecks[1].getName();
    String[] values = new String[4];



    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deckpage);
        values[0] = one;
        values[1] = two;
        values[2] = three;
        values[3] = allDecks[3].getName();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner = (Spinner) findViewById(R.id.static_spinner);

        toolbar.setTitle(getResources().getString(R.string.app_name));

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(DeckPage.this,
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

                }
                if(selection.equals("Home"))
                {
                    Intent intentLog = new Intent (DeckPage.this,MainActivity.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Study"))
                {
                    Intent intentLog = new Intent (DeckPage.this,StudyPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Help"))
                {
                    Intent intentLog = new Intent (DeckPage.this,HelpPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listView = (ListView)findViewById(R.id.listViewDecks);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mylistview, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(view.getContext(), EditDeck.class);
                    startActivityForResult(intent, 0);
                }
                if (position==1){
                    Intent intent = new Intent(view.getContext(), EditDeck.class);
                    startActivityForResult(intent, 0);
                }
                if (position==2){
                    Intent intent = new Intent(view.getContext(), EditDeck.class);
                    startActivityForResult(intent, 0);
                }
            };
        });

        };

    public void editDeck(View view) {
        Intent intentLog = new Intent (this,EditDeck.class);
        startActivity(intentLog);
        finish();
        return;
    }
    public void prevPage(View view) {
        Intent intentReg = new Intent(this,MainActivity.class);
        startActivity(intentReg);
        finish();
        return;
    }
};