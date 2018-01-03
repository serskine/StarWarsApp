package com.erskine.stuart.starwarsapp.cells;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erskine.stuart.starwarsapp.cells.AbstractCell;

/**
 * Created by Owner on 2/11/2017.
 * Copyright of Stuart Marr Erskine, all rights reserved.
 */

public interface ReadCell<Model> {
    void updateUi(Model model);
}
