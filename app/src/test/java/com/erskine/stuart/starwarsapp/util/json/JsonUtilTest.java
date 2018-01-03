package com.erskine.stuart.starwarsapp.util.json;

import com.erskine.stuart.starwarsapp.dice.pools.FacePool;
import com.erskine.stuart.starwarsapp.dice.results.Face;
import com.erskine.stuart.starwarsapp.util.logger.Logger;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by stuart.erskine on 2017-12-31.
 */

public class JsonUtilTest {

    @Test
    public void facePoolSerialization() {
        FacePool expectedObject = new FacePool(Face.DIFFICULTY_1, Face.CHALLENGE_1);
        String expectedJson = JsonUtil.toJson(expectedObject, true);

        Logger.debug(expectedJson);

        FacePool observedObject = JsonUtil.toObject(expectedJson, FacePool.class);
        String observedJson = JsonUtil.toJson(observedObject, true);

        assertEquals("Should match: ", expectedJson, observedJson);
    }
}
