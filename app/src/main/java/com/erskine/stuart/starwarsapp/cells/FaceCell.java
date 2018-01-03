package com.erskine.stuart.starwarsapp.cells;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.erskine.stuart.starwarsapp.R;
import com.erskine.stuart.starwarsapp.dice.results.Face;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public class FaceCell extends AbstractCell implements ReadCell<Face> {

    private FrameLayout theFrameLayout;
    private ImageView theImageView;

    public FaceCell(LayoutInflater inflater, View convertView, ViewGroup parent) {
        super(inflater, convertView, parent);
    }

    @Override
    public void updateUi(Face face) {
        if (face==null) {
            theImageView.setBackgroundResource(R.drawable.unknown);
        } else {
            theImageView.setBackgroundResource(face.icon);
        }
    }

    @Override
    public View createView(LayoutInflater inflater, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.cell_face, parent);
        theImageView = (ImageView) view.findViewById(R.id.theImageView);
        return view;
    }
}
