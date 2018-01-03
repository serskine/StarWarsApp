package com.erskine.stuart.starwarsapp.cells;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erskine.stuart.starwarsapp.R;
import com.erskine.stuart.starwarsapp.dice.pools.FacePool;
import com.erskine.stuart.starwarsapp.dice.pools.ResultPool;
import com.erskine.stuart.starwarsapp.util.view.ViewUtil;

import java.util.Map;

/**
 * Created by stuart.erskine on 2017-12-31.
 */

public class NamedFacePoolCell extends AbstractCell implements ReadCell<Map.Entry<String,FacePool>> {

    private TextView theNameText;
    private TextView theDescriptionText;
    private View theRollButton;
    private ViewGroup theDescriptionLayout;

    public NamedFacePoolCell(LayoutInflater inflater, View convertView, ViewGroup parent) {
        super(inflater, convertView, parent);
    }


    @Override
    public View createView(LayoutInflater inflater, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.cell_named_face_pool, parent);
        theRollButton = view.findViewById(R.id.theRollDiceButton);
        theNameText = (TextView) view.findViewById(R.id.theNameText);
        theDescriptionText = (TextView) view.findViewById(R.id.theDescriptionText);
        theDescriptionLayout = (ViewGroup) view.findViewById(R.id.theDescriptionLayout);
        return view;
    }

    @Override
    public void updateUi(Map.Entry<String, FacePool> stringFacePoolEntry) {
        final FacePool facePool = stringFacePoolEntry.getValue();
        final String name = stringFacePoolEntry.getKey();

        theNameText.setText(name);
        updateDescriptionTextOld(facePool);
        updateDescriptionLayout(facePool);
    }

    private void updateDescriptionLayout(FacePool facePool) {
        final ResultPool resultPool = facePool.getResults();

        if (resultPool.hasDespair()) {
            ImageCell imageCell = new ImageCell(inflater, null, theDescriptionLayout);
            imageCell.updateUi(R.drawable.despair);
            theDescriptionLayout.addView(imageCell.getView());
        }

        if (resultPool.hasTriumph()) {
            ImageCell imageCell = new ImageCell(inflater, null, theDescriptionLayout);
            imageCell.updateUi(R.drawable.triumph);
            theDescriptionLayout.addView(imageCell.getView());
        }

        if (resultPool.numSuccessVsFailure()<0) {
//            TextViewCell textViewCell = new TextViewCell(inflater, null, theDescriptionLayout);
//            textViewCell.updateUi("x" + -resultPool.numSuccessVsFailure());
//            theDescriptionLayout.addView(textViewCell.getView());
            for(int i=0; i<-resultPool.numSuccessVsFailure(); i++) {
                ImageCell imageCell = new ImageCell(inflater, null, theDescriptionLayout);
                imageCell.updateUi(R.drawable.failure);
                imageCell.updateSourceImage(R.drawable.failure);
                theDescriptionLayout.addView(imageCell.getView());
            }
        } else {
//            TextViewCell textViewCell = new TextViewCell(inflater, null, theDescriptionLayout);
//            textViewCell.updateUi("x" + resultPool.numSuccessVsFailure());
//            theDescriptionLayout.addView(textViewCell.getView());
            for(int i=0; i<resultPool.numSuccessVsFailure(); i++) {
                ImageCell imageCell = new ImageCell(inflater, null, theDescriptionLayout);
                imageCell.updateUi(R.drawable.success);
                theDescriptionLayout.addView(imageCell.getView());
            }
        }

        if (resultPool.goodVsBad()<0) {
//            TextViewCell textViewCell = new TextViewCell(inflater, null, theDescriptionLayout);
//            textViewCell.updateUi("x" + -resultPool.goodVsBad());
//            theDescriptionLayout.addView(textViewCell.getView());
            for(int i=0; i<-resultPool.goodVsBad(); i++) {
                ImageCell imageCell = new ImageCell(inflater, null, theDescriptionLayout);
                imageCell.updateUi(R.drawable.threat);
                theDescriptionLayout.addView(imageCell.getView());
            }
        } else if (resultPool.goodVsBad()>0) {
//            TextViewCell textViewCell = new TextViewCell(inflater, null, theDescriptionLayout);
//            textViewCell.updateUi("x" + resultPool.goodVsBad());
//            theDescriptionLayout.addView(textViewCell.getView());
            for(int i=0; i<resultPool.goodVsBad(); i++) {
                ImageCell imageCell = new ImageCell(inflater, null, theDescriptionLayout);
                imageCell.updateUi(R.drawable.advantage);
                theDescriptionLayout.addView(imageCell.getView());
            }
        }

    }

    private void updateDescriptionTextNew(FacePool facePool) {
        final ResultPool resultPool = facePool.getResults();

        theDescriptionText.setText(ViewUtil.toHtml("<html><pre>" + resultPool.graph() + "</pre></html>"));
    }

    private void updateDescriptionTextOld(FacePool facePool) {
        final ResultPool resultPool = facePool.getResults();
        String goodVsBad = "";
        String triumphDespair = "";
        String result = "";

        if (resultPool.goodVsBad()<0) {
            goodVsBad = (-facePool.getResults().goodVsBad()) + " x Setback";
        } else if (resultPool.goodVsBad()>0) {
            goodVsBad = facePool.getResults().goodVsBad() + " x Advantage";
        }

        if (resultPool.hasTriumph() && resultPool.hasDespair()) {
            triumphDespair = "Triumph and Despair!";
        } else if (resultPool.hasTriumph()) {
            triumphDespair = "Triumph!";
        } else if (resultPool.hasDespair()) {
            triumphDespair = "Despair!";
        }

        if (resultPool.isSuccess()) {
            result = resultPool.numSuccessVsFailure() + " x Success";
        } else {
            result = (-resultPool.numSuccessVsFailure()) + " x Failure";
        }


        String output = result;
        output += (goodVsBad.length()!=0) ? "\n" + goodVsBad: "";
        output += (resultPool.numLight()>0) ? "\n"  + resultPool.numLight() + " x Light side" : "";
        output += (resultPool.numDark()>0) ? "\n"  + resultPool.numDark() + " x Dark side" : "";
        output += (triumphDespair.length()!=0) ? "\n" + triumphDespair : "";
        theDescriptionText.setText(output);
    }
}
