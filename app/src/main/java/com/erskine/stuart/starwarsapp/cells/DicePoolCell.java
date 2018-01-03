package com.erskine.stuart.starwarsapp.cells;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erskine.stuart.starwarsapp.dice.pools.DicePool;

/**
 * Created by stuart.erskine on 2017-12-31.
 */

public class DicePoolCell extends AbstractCell implements ReadCell<DicePool> {

    public DicePoolCell(LayoutInflater inflater, View convertView, ViewGroup parent) {
        super(inflater, convertView, parent);
    }

    @Override
    public void updateUi(DicePool dicePool) {

    }

    @Override
    public View createView(LayoutInflater inflater, View convertView, ViewGroup parent) {
        return null;
    }
}
