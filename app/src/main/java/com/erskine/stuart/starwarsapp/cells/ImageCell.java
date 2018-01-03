package com.erskine.stuart.starwarsapp.cells;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.erskine.stuart.starwarsapp.R;

/**
 * Created by stuart.erskine on 2017-12-29.
 */

public class ImageCell extends AbstractCell implements ReadCell<Integer> {

    ImageView theImageView;

    public ImageCell(LayoutInflater inflater, View convertView, ViewGroup parent) {
        super(inflater, convertView, parent);
    }

    @Override
    public void updateUi(Integer drawableId) {
        updateSourceImage(drawableId);
        updateBackgroundImage(drawableId);
    }

    public void updateBackgroundImage(Integer drawableId) {
        if (drawableId==null) {
            theImageView.setBackgroundResource(R.drawable.unknown);
        } else {
            theImageView.setBackgroundResource(drawableId);
        }
    }

    public void updateSourceImage(Integer drawableId) {
        if (drawableId==null) {
            theImageView.setImageResource(0);
        } else {
            theImageView.setImageResource(drawableId);
        }
    }

    @Override
    public View createView(LayoutInflater inflater, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.cell_image, parent);
        theImageView = (ImageView) view.findViewById(R.id.theImageView);
        updateUi(null);
        return view;
    }
}
