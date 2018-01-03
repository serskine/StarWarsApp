package com.erskine.stuart.starwarsapp;

import com.erskine.stuart.starwarsapp.dice.Hist;
import com.erskine.stuart.starwarsapp.dice.results.Symbol;
import com.erskine.stuart.starwarsapp.util.logger.Logger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public class StarWarsLearningTest {
    @Test
    public void starwars_dice() throws Exception {
        Hist<Symbol> symbolHist1 = new Hist<>(
                Symbol.ADVANTAGE,
                Symbol.ADVANTAGE,
                Symbol.TRIUMPH
        );
        Hist<Symbol> symbolHist2 = new Hist<>(
                Symbol.DESPAIR,
                Symbol.ADVANTAGE,
                Symbol.THREAT,
                Symbol.THREAT,
                Symbol.THREAT,
                Symbol.THREAT,
                Symbol.THREAT,
                Symbol.DARK_SIDE,
                Symbol.LIGHT_SIDE,
                Symbol.LIGHT_SIDE,
                Symbol.LIGHT_SIDE,
                Symbol.FAILURE

        );

        Hist<Symbol> symbolHist = new Hist<>();
        symbolHist.increment(symbolHist1).increment(symbolHist2);

        Logger.info(symbolHist1.graph());
        Logger.info(symbolHist2.graph());
        Logger.info(symbolHist.graph(Symbol.values()));
        Logger.info(symbolHist.toString());

    }
}
