package com.erskine.stuart.starwarsapp.cells;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erskine.stuart.starwarsapp.R;
import com.erskine.stuart.starwarsapp.adapter.FacePoolAdapter;
import com.erskine.stuart.starwarsapp.dice.pools.FacePool;
import com.erskine.stuart.starwarsapp.dice.results.Die;
import com.erskine.stuart.starwarsapp.dice.results.Face;
import com.erskine.stuart.starwarsapp.util.logger.Logger;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stuart.erskine on 2017-12-29.
 */

public class FacePoolCell extends AbstractCell implements ReadCell<FacePool> {

    private ViewGroup theGroupsLayout;

    private FlexboxLayout theAbilityLayout;
    private FlexboxLayout theProficiencyLayout;
    private FlexboxLayout theBoostLayout;
    private FlexboxLayout theForceLayout;
    private FlexboxLayout theDifficultyLayout;
    private FlexboxLayout theChallengeLayout;
    private FlexboxLayout theSetbackLayout;

    private FacePoolAdapter theFacePoolAdapter;

    public FacePoolCell(LayoutInflater inflater, View convertView, ViewGroup parent) {
        super(inflater, convertView, parent);
        theFacePoolAdapter = new FacePoolAdapter(inflater, new ArrayList<Face>());
    }

    @Override
    public void updateUi(FacePool facePool) {
        clear();
        if (facePool!=null) {
            List<Face> faces = facePool.getFaces();
            updateFaces(faces);
        }
    }

    @Override
    public View createView(LayoutInflater inflater, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.cell_face_pool, parent);

        theGroupsLayout = (ViewGroup) view.findViewById(R.id.theGroupsLayout);

        theAbilityLayout = (FlexboxLayout) view.findViewById(R.id.theAbilityLayout);
        theProficiencyLayout = (FlexboxLayout) view.findViewById(R.id.theProficiencyLayout);
        theBoostLayout = (FlexboxLayout) view.findViewById(R.id.theBoostLayout);
        theForceLayout = (FlexboxLayout) view.findViewById(R.id.theForceLayout);
        theDifficultyLayout = (FlexboxLayout) view.findViewById(R.id.theDifficultyLayout);
        theChallengeLayout = (FlexboxLayout) view.findViewById(R.id.theChallengeLayout);
        theSetbackLayout = (FlexboxLayout) view.findViewById(R.id.theSetbackLayout);

        updateUi(null);
        return view;
    }
    
    private void clear() {
         theAbilityLayout.removeAllViews();
         theProficiencyLayout.removeAllViews();
         theBoostLayout.removeAllViews();
         theForceLayout.removeAllViews();
         theDifficultyLayout.removeAllViews();
         theChallengeLayout.removeAllViews();
         theSetbackLayout.removeAllViews();
    }

    private void updateFaces(List<Face> faces) {
        theFacePoolAdapter.setData(faces);
        for (int i = 0; i < faces.size(); i++) {
            Face face = faces.get(i);
            ViewGroup parentLayout = getParentLayout(face);
            View faceView = theFacePoolAdapter.getView(i, null, parentLayout);
            parentLayout.addView(faceView);
        }
        theGroupsLayout.refreshDrawableState();
    }

    private FlexboxLayout getParentLayout(Face face) {
        Die die = face.die;
        switch(die) {
            case ABILITY:
                return theAbilityLayout;
            case DIFFICULTY:
                return theDifficultyLayout;
            case PROFICIENCY:
                return theProficiencyLayout;
            case CHALLENGE:
                return theChallengeLayout;
            case BOOST:
                return theBoostLayout;
            case SETBACK:
                return theSetbackLayout;
            case FORCE:
                return theForceLayout;
            default:
                throw new RuntimeException("We have to layout to add face " + face + " to because it's die " + face.die + " is unsupported.");
        }
    }
}
