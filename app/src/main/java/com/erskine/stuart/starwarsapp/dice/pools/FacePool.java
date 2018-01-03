package com.erskine.stuart.starwarsapp.dice.pools;

import com.erskine.stuart.starwarsapp.dice.results.Face;
import com.erskine.stuart.starwarsapp.dice.Hist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public class FacePool extends Hist<Face> implements Serializable {

    public FacePool() {
        this(new Face[] {});
    }

    public FacePool(Face... faces) {
        super(
            new Comparator<Face>() {
                  @Override
                  public int compare(Face o1, Face o2) {
                      return o1.ordinal() - o2.ordinal();
                  }
            },
            0L,
            faces
        );
    }

    public List<Face> getFaces() {
        List<Face> faces = new ArrayList<>();
        for(Face face : Face.values()) {
            for(int i=0; i<count(face); i++) {
                faces.add(face);
            }
        }
        return faces;
    }

    public ResultPool getResults() {
        ResultPool resultPool = new ResultPool();
        for(Face face : keySet()) {
            resultPool.increment(face.getResults());
        }
        return resultPool;
    }

    public DicePool createMatchingDicePool() {
        DicePool dicePool = new DicePool();
        for(Face face : keySet()) {
            dicePool.increment(face.die);
        }
        return dicePool;
    }
}
