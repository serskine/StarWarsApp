package com.erskine.stuart.starwarsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.erskine.stuart.starwarsapp.cells.FaceCell;
import com.erskine.stuart.starwarsapp.dice.results.Face;

import java.util.List;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public class FacePoolAdapter extends CustomListAdapter<Face> {

    ImageView theImage;

    public FacePoolAdapter(LayoutInflater inflater, List<Face> faces) {
        super(inflater);
        setData(faces);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FaceCell faceCell = new FaceCell(inflater, convertView, parent);
        faceCell.updateUi((position<getCount()) ? getCastedItem(position) : null);
        return faceCell.getView();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }
}
