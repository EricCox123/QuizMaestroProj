package com.example.eric.quizmaestro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


import java.util.List;

public class arrayAdapter extends ArrayAdapter<DeckPage.Deck> {

    Context context;

    public arrayAdapter(Context context, int resourceID, List<DeckPage.Deck> items) {
        super(context, resourceID, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        DeckPage.Deck deck_item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);

        }
        TextView name = (TextView) convertView.findViewById(R.id.deckName);
        TextView question = (TextView) convertView.findViewById(R.id.carQ);
        TextView answer = (TextView) convertView.findViewById(R.id.carA);
        //TextView name = (TextView) convertView.findViewById(R.id.deckName);
        name.setText(deck_item.getName());
        return convertView;

    }
}
