package com.erskine.stuart.starwarsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erskine.stuart.starwarsapp.cells.NamedFacePoolCell;
import com.erskine.stuart.starwarsapp.dice.pools.FacePool;
import com.erskine.stuart.starwarsapp.util.common.Pair;

import java.util.Map;

/**
 * Created by stuart.erskine on 2017-12-31.
 */

public class NamedFacePoolAdapter extends CustomListAdapter<Pair<String, FacePool>> {
    public NamedFacePoolAdapter(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NamedFacePoolCell cell = new NamedFacePoolCell(inflater, null, parent);
        cell.updateUi(getCastedItem(position));
        return cell.getView();
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
