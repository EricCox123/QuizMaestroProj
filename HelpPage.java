package com.example.eric.quizmaestro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


class HelpPage extends AppCompatActivity {

    Toolbar toolbar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helppage);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        spinner = (Spinner) findViewById(R.id.static_spinner);

        toolbar.setTitle(getResources().getString(R.string.app_name));

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(HelpPage.this,
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
                    Intent intentLog = new Intent (HelpPage.this,DeckPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Study"))
                {
                    Intent intentLog = new Intent (HelpPage.this,StudyPage.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Home"))
                {
                    Intent intentLog = new Intent (HelpPage.this,MainActivity.class);
                    startActivity(intentLog);
                    finish();
                    return;
                }
                if(selection.equals("Help"))
                {

                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
