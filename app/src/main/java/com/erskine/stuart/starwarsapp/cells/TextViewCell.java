package com.erskine.stuart.starwarsapp.cells;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erskine.stuart.starwarsapp.R;

/**
 * Created by stuart.erskine on 2017-12-31.
 */

public class TextViewCell extends AbstractCell implements ReadCell<String> {
    TextView theTextView;

    public TextViewCell(LayoutInflater inflater, View convertView, ViewGroup parent) {
        super(inflater, convertView, parent);
    }

    @Override
    public void updateUi(String s) {
        if (s==null) {
            theTextView.setText("");
        } else {
            theTextView.setText(s);
        }
    }

    @Override
    public View createView(LayoutInflater inflater, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.cell_text, parent);
        theTextView = (TextView) view.findViewById(R.id.theTextView);
        updateUi(null);
        return view;
    }
}
