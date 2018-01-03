package com.erskine.stuart.starwarsapp;

import android.app.Activity;
import android.content.Intent;
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
import com.erskine.stuart.starwarsapp.util.json.JsonUtil;
import com.erskine.stuart.starwarsapp.util.logger.Logger;

import java.util.ArrayList;
import java.util.List;


public class BuildDicePoolActivity extends AppActivity {

    public static final String KEY_DICE_POOL = "KEY_DICE_POOL";
    public static final String KEY_FACE_POOL = "KEY_FACE_POOL";

    private FacePoolAdapter theListAdapter;
    private FrameLayout theFrameLayout;

    private DicePool dicePool = new DicePool(); // Dice we will roll
    private FacePool facePool = new FacePool(); // Current faces displayed

    private FacePoolCell facePoolCell;

    /**
     * Use this method to start this activity from another activity.
     * @param source is the activity you are currently on
     * @param facePool is the initial pool of faces you wish to use. If null, a new one will be created
     * @param requestCode is the request code we are using to return when we have our results.
     */
    public static final void start(Activity source, FacePool facePool, int requestCode) {
        Intent intent = new Intent(source, BuildDicePoolActivity.class);

        if (facePool != null) {
            DicePool dicePool = facePool.createMatchingDicePool();

            intent.putExtra(KEY_DICE_POOL, dicePool);
            intent.putExtra(KEY_FACE_POOL, facePool);
        }
        source.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // recovering the instance state
        if (savedInstanceState != null) {
            dicePool = (DicePool) savedInstanceState.getSerializable(KEY_DICE_POOL);
            facePool = (FacePool) savedInstanceState.getSerializable(KEY_FACE_POOL);
        }

        switch (getResources().getConfiguration().orientation) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.landscape_activity_build_dice_pool);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
            default:
                setContentView(R.layout.portrait_activity_build_dice_pool);
                break;
        }

        theFrameLayout = (FrameLayout) findViewById(R.id.theFrameLayout);
        theListAdapter = new FacePoolAdapter(getLayoutInflater(), new ArrayList<Face>());

        facePoolCell = new FacePoolCell(getLayoutInflater(), null, theFrameLayout);
        theFrameLayout.addView(facePoolCell.getView());

        updateUi();
    }

    @Override
    public void onStop() {
        super.onStop();
        Intent intent = new Intent();
        intent.putExtra(KEY_FACE_POOL, facePool);
        setResult(RESULT_OK, intent);
    }

    public void rollDice(View view) {
        facePool = dicePool.roll();
        updateUi();
    }

    public void clearDice(View view) {
        dicePool.clear();
        facePool.clear();
        updateUi();
    }

    public void addForceDie(View view) { addDie(Die.FORCE); }

    public void addAbilityDie(View view) {
        addDie(Die.ABILITY);
    }

    public void addDifficultyDie(View view) {
        addDie(Die.DIFFICULTY);
    }

    public void addProficiencyDie(View view) {
        addDie(Die.PROFICIENCY);
    }

    public void addChallengeDie(View view) {
        addDie(Die.CHALLENGE);
    }

    public void addBoostDie(View view) {
        addDie(Die.BOOST);
    }

    public void addSetbackDie(View view) {
        addDie(Die.SETBACK);
    }

    public void addDie(Die die) {
        DicePool newDice = new DicePool(die);
        FacePool newFaces = newDice.roll();

        dicePool.increment(newDice);
        facePool.increment(newFaces);
        updateUi();
    }

    public void updateUi() {
        List<Face> faces = facePool.getFaces();
        theListAdapter.setData(faces);
        theListAdapter.notifyObservers();
        facePoolCell.updateUi(facePool);
    }

    // This callback is called only when there is a saved instance previously saved using
    // onSaveInstanceState(). We restore some state in onCreate() while we can optionally restore
    // other state here, possibly usable after onStart() has completed.
    // The savedInstanceState Bundle is same as the one used in onCreate().
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);

        outState.putSerializable(KEY_DICE_POOL, dicePool);
        outState.putSerializable(KEY_FACE_POOL, facePool);
    }

    public void onClickSaveButton(View view) {

        Logger.debug("onClickSaveButton()");
        Logger.debug(facePool.graph());

        final String responseJson = JsonUtil.toJson(facePool, true);
        Intent intent = new Intent();
        intent.putExtra(KEY_RESPONSE_JSON, responseJson);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onClickCancelButton(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
