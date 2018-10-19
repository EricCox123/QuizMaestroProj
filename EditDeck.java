package com.example.eric.quizmaestro;
import com.example.eric.quizmaestro.DeckPage;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


public class EditDeck extends AppCompatActivity {

    private EditText curQuestion;
    private EditText curDeck;
    private EditText curAnswer;
    private String curDeckName;
    private String question, answer;
    private String deckQ[] = new String[10];
    private String deckA[] = new String[10];
    private int numCards = 0;
    Toolbar toolbar;
    Spinner spinner;

    DeckPage.Deck ok = new DeckPage.Deck("hi");
    DeckPage.Deck testDeck = new DeckPage.Deck("TestDeck");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdeck);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner = (Spinner) findViewById(R.id.static_spinner);

        toolbar.setTitle(getResources().getString(R.string.app_name));

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EditDeck.this,
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
                    Intent intentLog = new Intent (EditDeck.this,DeckPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Home"))
                {
                    Intent intentLog = new Intent (EditDeck.this,MainActivity.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Study"))
                {
                    Intent intentLog = new Intent (EditDeck.this,StudyPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Help"))
                {
                    Intent intentLog = new Intent (EditDeck.this,HelpPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void prevPage(View view) {
        Intent intentReg = new Intent(EditDeck.this,DeckPage.class);
        startActivity(intentReg);
        finish();
        return;
    }

    public void addCard(View view) {
        curDeck = (EditText)findViewById(R.id.deckName);
        curQuestion = (EditText)findViewById(R.id.carQ);
        curAnswer =(EditText)findViewById(R.id.carA);
        question = curQuestion.getText().toString();
        answer = curAnswer.getText().toString();
        curDeckName = curDeck.getText().toString();
        deckQ[numCards] = question;
        deckA[numCards] = answer;
        numCards++;
        DeckPage.Deck curDeckUse;
        curDeckUse = new DeckPage.Deck(curDeckName);
        DeckPage.Card curCard = new DeckPage.Card("cardID", question, answer);
        DeckPage.addCardToDeck(curDeckUse, curCard, getApplicationContext());

        //deck object needed.
        Toast.makeText(this, "Card Added to deck: " + curDeckUse.getName() + ".",Toast.LENGTH_SHORT).show();
    }

}