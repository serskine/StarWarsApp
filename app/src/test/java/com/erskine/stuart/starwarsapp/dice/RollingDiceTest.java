package com.erskine.stuart.starwarsapp.dice;

import com.erskine.stuart.starwarsapp.dice.pools.DicePool;
import com.erskine.stuart.starwarsapp.dice.pools.ResultPool;
import com.erskine.stuart.starwarsapp.dice.results.Die;
import com.erskine.stuart.starwarsapp.util.logger.Logger;

import org.junit.Test;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public class RollingDiceTest {

    @Test
    public void rollDie() {
        ResultPool totalResults = new ResultPool();
        for(Die die : Die.values()) {
            for(int i=0; i<3; i++) {
                totalResults.increment(DicePool.rollDie(die).getResults());
            }
        }

        logResults(totalResults);
    }

    private void logResults(ResultPool totalResults) {
        Logger.info("=== total results ===\n" + totalResults.graph());
        Logger.info("numSuccess       = " + totalResults.numSuccess());
        Logger.info("numFailure       = " + totalResults.numFailure());
        Logger.info("successVsFailure = " + totalResults.numSuccessVsFailure());
        Logger.info("isSuccess        = " + totalResults.isSuccess());
        Logger.info("goodVsBad        = " + totalResults.goodVsBad());
        Logger.info("isTriumph        = " + totalResults.hasTriumph());
        Logger.info("isDespair        = " + totalResults.hasDespair());
        Logger.info("numDark          = " + totalResults.numDark());
        Logger.info("numLight         = " + totalResults.numLight());
        Logger.info("toString         = " + totalResults.toString());
    }
}
