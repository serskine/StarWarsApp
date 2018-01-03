package com.erskine.stuart.starwarsapp.dice.pools;

import com.erskine.stuart.starwarsapp.dice.results.Die;
import com.erskine.stuart.starwarsapp.dice.Hist;
import com.erskine.stuart.starwarsapp.dice.results.Face;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public class DicePool extends Hist<Die> {
    private static final Random RANDOM = new Random();

    public DicePool(Die... dice) {
        super(
            new Comparator<Die>() {
                @Override
                public int compare(Die o1, Die o2) {
                    return o1.ordinal() - o2.ordinal();
                }
            },
            0L,
            dice
        );
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Die die : Die.values()) {
            for(int i=0; i<count(die); i++) {
                stringBuilder.append(die.code);
            }
        }
        return stringBuilder.toString();
    }

    public FacePool roll() {
        FacePool facePool = new FacePool();
        for(Die die : keySet()) {
            for(int i=0; i<count(die); i++) {
                facePool.increment(rollDie(die));
            }
        }
        return facePool;
    }

    public static final Face rollDie(Die die) {
        switch(die) {
            case ABILITY:
                return rollAbility();
            case DIFFICULTY:
                return rollDifficulty();
            case PROFICIENCY:
                return rollProficiency();
            case CHALLENGE:
                return rollChallenge();
            case BOOST:
                return rollBoost();
            case SETBACK:
                return rollSetback();
            case FORCE:
                return rollForce();
            default:
                throw new RuntimeException("Unsupported die (" + die + ")");
        }
    }

    public static final int rollInt(int size) {
        return (int) ((Math.random() * size) + 1);
    }

    public static Face rollBoost() {
        int roll = rollInt(6);
        switch(roll) {
            case 1:
                return Face.BOOST_1;
            case 2:
                return Face.BOOST_2;
            case 3:
                return Face.BOOST_3;
            case 4:
                return Face.BOOST_4;
            case 5:
                return Face.BOOST_5;
            case 6:
                return Face.BOOST_6;
            default:
                throw new RuntimeException("Unknown face for a boost die (roll = " + roll + ")");
        }
    }

    public static Face rollSetback() {
        int roll = rollInt(6);
        switch(roll) {
            case 1:
                return Face.SETBACK_1;
            case 2:
                return Face.SETBACK_2;
            case 3:
                return Face.SETBACK_3;
            case 4:
                return Face.SETBACK_4;
            case 5:
                return Face.SETBACK_5;
            case 6:
                return Face.SETBACK_6;
            default:
                throw new RuntimeException("Unknown face for a setback die (roll = " + roll + ")");
        }
    }

    public static Face rollAbility() {
        int roll = rollInt(8);
        switch(roll) {
            case 1:
                return Face.ABILITY_1;
            case 2:
                return Face.ABILITY_2;
            case 3:
                return Face.ABILITY_3;
            case 4:
                return Face.ABILITY_4;
            case 5:
                return Face.ABILITY_5;
            case 6:
                return Face.ABILITY_6;
            case 7:
                return Face.ABILITY_7;
            case 8:
                return Face.ABILITY_8;
            default:
                throw new RuntimeException("Unknown face for an ability die (roll = " + roll + ")");
        }
    }

    public static Face rollDifficulty() {
        int roll = rollInt(8);
        switch(roll) {
            case 1:
                return Face.DIFFICULTY_1;
            case 2:
                return Face.DIFFICULTY_2;
            case 3:
                return Face.DIFFICULTY_3;
            case 4:
                return Face.DIFFICULTY_4;
            case 5:
                return Face.DIFFICULTY_5;
            case 6:
                return Face.DIFFICULTY_6;
            case 7:
                return Face.DIFFICULTY_7;
            case 8:
                return Face.DIFFICULTY_8;
            default:
                throw new RuntimeException("Unknown face for an difficulty die (roll = " + roll + ")");
        }
    }

    public static Face rollProficiency() {
        int roll = rollInt(12);
        switch(roll) {
            case 1:
                return Face.PROFICIENCY_1;
            case 2:
                return Face.PROFICIENCY_2;
            case 3:
                return Face.PROFICIENCY_3;
            case 4:
                return Face.PROFICIENCY_4;
            case 5:
                return Face.PROFICIENCY_5;
            case 6:
                return Face.PROFICIENCY_6;
            case 7:
                return Face.PROFICIENCY_7;
            case 8:
                return Face.PROFICIENCY_8;
            case 9:
                return Face.PROFICIENCY_9;
            case 10:
                return Face.PROFICIENCY_10;
            case 11:
                return Face.PROFICIENCY_11;
            case 12:
                return Face.PROFICIENCY_12;
            default:
                throw new RuntimeException("Unknown face for an proficiency die (roll = " + roll + ")");
        }
    }

    public static Face rollChallenge() {
        int roll = rollInt(12);
        switch(roll) {
            case 1:
                return Face.CHALLENGE_1;
            case 2:
                return Face.CHALLENGE_2;
            case 3:
                return Face.CHALLENGE_3;
            case 4:
                return Face.CHALLENGE_4;
            case 5:
                return Face.CHALLENGE_5;
            case 6:
                return Face.CHALLENGE_6;
            case 7:
                return Face.CHALLENGE_7;
            case 8:
                return Face.CHALLENGE_8;
            case 9:
                return Face.CHALLENGE_9;
            case 10:
                return Face.CHALLENGE_10;
            case 11:
                return Face.CHALLENGE_11;
            case 12:
                return Face.CHALLENGE_12;
            default:
                throw new RuntimeException("Unknown face for an challenge die (roll = " + roll + ")");
        }
    }

    public static Face rollForce() {
        int roll = rollInt(12);
        switch(roll) {
            case 1:
                return Face.FORCE_1;
            case 2:
                return Face.FORCE_2;
            case 3:
                return Face.FORCE_3;
            case 4:
                return Face.FORCE_4;
            case 5:
                return Face.FORCE_5;
            case 6:
                return Face.FORCE_6;
            case 7:
                return Face.FORCE_7;
            case 8:
                return Face.FORCE_8;
            case 9:
                return Face.FORCE_9;
            case 10:
                return Face.FORCE_10;
            case 11:
                return Face.FORCE_11;
            case 12:
                return Face.FORCE_12;
            default:
                throw new RuntimeException("Unknown face for a force die (roll = " + roll + ")");
        }
    }


}
