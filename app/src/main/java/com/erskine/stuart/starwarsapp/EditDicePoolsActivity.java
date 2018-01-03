package com.erskine.stuart.starwarsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.erskine.stuart.starwarsapp.adapter.NamedFacePoolAdapter;
import com.erskine.stuart.starwarsapp.dice.pools.FacePool;
import com.erskine.stuart.starwarsapp.util.common.Pair;
import com.erskine.stuart.starwarsapp.util.json.JsonUtil;
import com.erskine.stuart.starwarsapp.util.logger.Logger;

import java.util.ArrayList;

public class EditDicePoolsActivity extends AppListActivity {

    public static final String KEY_DICE_POOLS = "KEY_DICE_POOLS";

    private ArrayList<Pair<String, FacePool>> entries = new ArrayList<>();
    
    private NamedFacePoolAdapter theListViewAdapter;

    private ListView theListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        theListView = (ListView) findViewById(R.id.theListView);

        theListViewAdapter = new NamedFacePoolAdapter(getLayoutInflater());
        theListViewAdapter.setData(entries);
        theListView.setAdapter(theListViewAdapter);

        theListViewAdapter.setData(entries);
    }

    public void onFilterButtonClicked(View view) {
        super.onFilterButtonClicked(view);
    }

    public void onClearButtonClicked(View view) {
        super.onClearButtonClicked(view);
    }

    public void onEditButtonClicked(View view) {
        super.onEditButtonClicked(view);
    }

    public void onRemoveButtonClicked(View view) {
        super.onRemoveButtonClicked(view);
    }

    public void onAddButtonClicked(View view) {
        super.onAddButtonClicked(view);
        final int idx = addFacePool();
        Pair<String, FacePool> entry = entries.get(idx);

        BuildDicePoolActivity.start(this, entry.getValue(), idx);
    }

    public void onClearFilterButtonClicked(View view) {
        super.onClearFilterButtonClicked(view);
    }

    private int addFacePool() {
        FacePool facePool = new FacePool();
        final int index = entries.size();
        final String facePoolName = "Item " + index;
        Pair<String, FacePool> entry = new Pair(facePoolName, facePool);
        entries.add(entry);
        return index;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Logger.debug("onActivityResult(" + requestCode + ", " + resultCode + ", data)");
        if (resultCode == RESULT_OK) {
            String responseJson = data.getStringExtra(KEY_RESPONSE_JSON);
            Logger.debug(" - RESULT is OK");
            Logger.debug(responseJson);
            FacePool facePool = JsonUtil.toObject(responseJson, FacePool.class);
            Logger.debug(facePool.graph());
            Pair<String, FacePool> pair = entries.get(requestCode);
            pair.setValue(facePool);

            theListViewAdapter.setData(entries);
        } else {
            Logger.debug(" - RESULT is not OK");
        }
    }

}
