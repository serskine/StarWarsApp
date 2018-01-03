package com.erskine.stuart.starwarsapp.dice.pools;

import com.erskine.stuart.starwarsapp.dice.Hist;
import com.erskine.stuart.starwarsapp.dice.results.Symbol;

import java.util.Comparator;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public class ResultPool extends Hist<Symbol> {

    public ResultPool(Symbol... symbols) {
        super(
            new Comparator<Symbol>() {
                @Override
                public int compare(Symbol o1, Symbol o2) {
                    return o1.ordinal() - o2.ordinal();
                }
            },
            0L,
            symbols
        );
    }

    /**
     * @return the number of siccess symbols present in the dice pool
     */
    public long numSuccess() {
        return count(Symbol.SUCCESS) + count(Symbol.TRIUMPH);
    }

    /**
     * @return the number of failure symbols present in the dice pool
     */
    public long numFailure() {
        return count(Symbol.FAILURE) + count(Symbol.DESPAIR);
    }

    /**
     * @return the difference between the number of successes and the number of failure symbols
     * present in the dice pool
     */
    public long numSuccessVsFailure() {
        return numSuccess() - numFailure();
    }

    /**
     * @return true if the number of success symbols are greater than the number of failure symbols
     * present in the result pool.
     */
    public boolean isSuccess() {
        return (numSuccessVsFailure()>0);
    }

    /**
     * @return true if there is a {@link Symbol#TRIUMPH} present in the dice pool
     */
    public boolean hasTriumph() {
        return (count(Symbol.TRIUMPH)>0);
    }

    /**
     * @return true if there is a {@link Symbol#DESPAIR} present in the dice pool
     */
    public boolean hasDespair() {
        return (count(Symbol.DESPAIR)>0);
    }

    /**
     * @return the number of {@link Symbol#ADVANTAGE} symbols found in the dice pool
     */
    public long numAdvantage() {
        return count(Symbol.ADVANTAGE);
    }

    /**
     * @return the number of {@link Symbol#THREAT} symbols found in the dice pool
     */
    public long numThreat() {
        return count(Symbol.THREAT);
    }

    /**
     * This will return the net difference between the number of {@link Symbol#ADVANTAGE} and {@link Symbol#THREAT}
     * @return number of {@link Symbol#ADVANTAGE} - number of {@link Symbol#THREAT}
     */
    public long goodVsBad() {
        return numAdvantage() - numThreat();
    }

    public long numLight() {
        return count(Symbol.LIGHT_SIDE);
    }

    public long numDark() {
        return count(Symbol.DARK_SIDE);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Symbol symbol : Symbol.values()) {
            for(int i=0; i<count(symbol); i++) {
                stringBuilder.append(symbol.code);
            }
        }
        return stringBuilder.toString();
    }
}
