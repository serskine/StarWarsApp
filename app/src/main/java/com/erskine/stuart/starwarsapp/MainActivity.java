package com.erskine.stuart.starwarsapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.erskine.stuart.starwarsapp.adapter.FacePoolAdapter;
import com.erskine.stuart.starwarsapp.cells.FacePoolCell;
import com.erskine.stuart.starwarsapp.dice.pools.DicePool;
import com.erskine.stuart.starwarsapp.dice.pools.FacePool;
import com.erskine.stuart.starwarsapp.dice.results.Die;
import com.erskine.stuart.starwarsapp.dice.results.Face;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BuildDicePoolActivity.start(this, null, 0);
    }
}
