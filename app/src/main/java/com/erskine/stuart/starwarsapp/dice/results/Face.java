package com.erskine.stuart.starwarsapp.dice.results;

import com.erskine.stuart.starwarsapp.R;
import com.erskine.stuart.starwarsapp.dice.pools.ResultPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public enum Face {
    ABILITY_1       (Die.ABILITY,       R.drawable.green_),        // blank
    ABILITY_2       (Die.ABILITY,       R.drawable.green_s),       // 1 success
    ABILITY_3       (Die.ABILITY,       R.drawable.green_s),       // 1 success
    ABILITY_4       (Die.ABILITY,       R.drawable.green_ss),      // 2 success
    ABILITY_5       (Die.ABILITY,       R.drawable.green_a),       // 1 advantage
    ABILITY_6       (Die.ABILITY,       R.drawable.green_a),       // 1 advantage
    ABILITY_7       (Die.ABILITY,       R.drawable.green_sa),      // 1 success, 1 advantage
    ABILITY_8       (Die.ABILITY,       R.drawable.green_aa),      // 2 advantage
    DIFFICULTY_1    (Die.DIFFICULTY,    R.drawable.purple_),       // blank
    DIFFICULTY_2    (Die.DIFFICULTY,    R.drawable.purple_f),      // 1 failure
    DIFFICULTY_3    (Die.DIFFICULTY,    R.drawable.purple_f),      // 2 failure
    DIFFICULTY_4    (Die.DIFFICULTY,    R.drawable.purple_t),      // 1 threat
    DIFFICULTY_5    (Die.DIFFICULTY,    R.drawable.purple_t),      // 1 threat
    DIFFICULTY_6    (Die.DIFFICULTY,    R.drawable.purple_t),      // 1 threat
    DIFFICULTY_7    (Die.DIFFICULTY,    R.drawable.purple_tt),     // 2 threat
    DIFFICULTY_8    (Die.DIFFICULTY,    R.drawable.purple_ft),     // 1 failure, 1 threat
    PROFICIENCY_1   (Die.PROFICIENCY,   R.drawable.yellow_),       // blank
    PROFICIENCY_2   (Die.PROFICIENCY,   R.drawable.yellow_s),      // 1 success
    PROFICIENCY_3   (Die.PROFICIENCY,   R.drawable.yellow_s),      // 1 success
    PROFICIENCY_4   (Die.PROFICIENCY,   R.drawable.yellow_ss),     // 2 success
    PROFICIENCY_5   (Die.PROFICIENCY,   R.drawable.yellow_ss),     // 2 success
    PROFICIENCY_6   (Die.PROFICIENCY,   R.drawable.yellow_a),      // 1 advantage
    PROFICIENCY_7   (Die.PROFICIENCY,   R.drawable.yellow_sa),     // 1 success, 1 advantage
    PROFICIENCY_8   (Die.PROFICIENCY,   R.drawable.yellow_sa),     // 1 success, 1 advantage
    PROFICIENCY_9   (Die.PROFICIENCY,   R.drawable.yellow_sa),     // 1 success, 1 advantage
    PROFICIENCY_10  (Die.PROFICIENCY,   R.drawable.yellow_aa),     // 2 advantage
    PROFICIENCY_11  (Die.PROFICIENCY,   R.drawable.yellow_aa),     // 2 advantage
    PROFICIENCY_12  (Die.PROFICIENCY,   R.drawable.yellow_r),      // 1 triumph
    CHALLENGE_1     (Die.CHALLENGE,     R.drawable.red_),          // 1 blank
    CHALLENGE_2     (Die.CHALLENGE,     R.drawable.red_f),         // 1 failure
    CHALLENGE_3     (Die.CHALLENGE,     R.drawable.red_f),         // 1 failure
    CHALLENGE_4     (Die.CHALLENGE,     R.drawable.red_ff),        // 2 failure
    CHALLENGE_5     (Die.CHALLENGE,     R.drawable.red_ff),        // 2 failure
    CHALLENGE_6     (Die.CHALLENGE,     R.drawable.red_t),         // 1 threat
    CHALLENGE_7     (Die.CHALLENGE,     R.drawable.red_t),         // 1 threat
    CHALLENGE_8     (Die.CHALLENGE,     R.drawable.red_ft),        // 1 failure, 1 threat
    CHALLENGE_9     (Die.CHALLENGE,     R.drawable.red_ft),        // 1 failure, 1 threat
    CHALLENGE_10    (Die.CHALLENGE,     R.drawable.red_tt),        // 2 threat
    CHALLENGE_11    (Die.CHALLENGE,     R.drawable.red_tt),        // 2 threat
    CHALLENGE_12    (Die.CHALLENGE,     R.drawable.red_d),         // 1 despair
    BOOST_1         (Die.BOOST,         R.drawable.blue_),         // 1 blank
    BOOST_2         (Die.BOOST,         R.drawable.blue_),         // 1 blank
    BOOST_3         (Die.BOOST,         R.drawable.blue_aa),       // 2 advantage
    BOOST_4         (Die.BOOST,         R.drawable.blue_a),        // 1 advantage
    BOOST_5         (Die.BOOST,         R.drawable.blue_sa),       // 1 success, 1 advantage
    BOOST_6         (Die.BOOST,         R.drawable.blue_s),        // 1 success
    SETBACK_1       (Die.SETBACK,       R.drawable.black_),        // blank
    SETBACK_2       (Die.SETBACK,       R.drawable.black_),        // blank
    SETBACK_3       (Die.SETBACK,       R.drawable.black_f),       // 1 failure
    SETBACK_4       (Die.SETBACK,       R.drawable.black_f),       // 1 failure
    SETBACK_5       (Die.SETBACK,       R.drawable.black_t),       // 1 threat
    SETBACK_6       (Die.SETBACK,       R.drawable.black_t),       // 1 threat
    FORCE_1         (Die.FORCE,         R.drawable.white_n),       // 1 dark side
    FORCE_2         (Die.FORCE,         R.drawable.white_n),       // 1 dark side
    FORCE_3         (Die.FORCE,         R.drawable.white_n),       // 1 dark side
    FORCE_4         (Die.FORCE,         R.drawable.white_n),       // 1 dark side
    FORCE_5         (Die.FORCE,         R.drawable.white_n),       // 1 dark side
    FORCE_6         (Die.FORCE,         R.drawable.white_n),       // 1 dark side
    FORCE_7         (Die.FORCE,         R.drawable.white_nn),      // 2 dark side
    FORCE_8         (Die.FORCE,         R.drawable.white_l),       // 1 light side
    FORCE_9         (Die.FORCE,         R.drawable.white_l),       // 1 light side
    FORCE_10        (Die.FORCE,         R.drawable.white_ll),      // 2 light side
    FORCE_11        (Die.FORCE,         R.drawable.white_ll),      // 2 light side
    FORCE_12        (Die.FORCE,         R.drawable.white_ll);      // 2 light side

    public final int icon;
    public final Die die;

    Face(Die die, int icon) {
        this.die = die;
        this.icon = icon;
    }

    public ResultPool getResults() {
        switch(this) {
            case ABILITY_1:
                return new ResultPool();
            case ABILITY_2:
            case ABILITY_3:
                return new ResultPool(Symbol.SUCCESS);
            case ABILITY_4:
                return new ResultPool(Symbol.SUCCESS, Symbol.SUCCESS);
            case ABILITY_5:
            case ABILITY_6:
                return new ResultPool(Symbol.ADVANTAGE);
            case ABILITY_7:
                return new ResultPool(Symbol.SUCCESS, Symbol.ADVANTAGE);
            case ABILITY_8:
                return new ResultPool(Symbol.ADVANTAGE, Symbol.ADVANTAGE);
            case DIFFICULTY_1:
                return new ResultPool();
            case DIFFICULTY_2:
                return new ResultPool(Symbol.FAILURE);
            case DIFFICULTY_3:
                return new ResultPool(Symbol.FAILURE, Symbol.FAILURE);
            case DIFFICULTY_4:
            case DIFFICULTY_5:
            case DIFFICULTY_6:
                return new ResultPool(Symbol.THREAT);
            case DIFFICULTY_7:
                return new ResultPool(Symbol.THREAT, Symbol.THREAT);
            case DIFFICULTY_8:
                return new ResultPool(Symbol.FAILURE, Symbol.THREAT);
            case PROFICIENCY_1:
                return new ResultPool();
            case PROFICIENCY_2:
            case PROFICIENCY_3:
                return new ResultPool(Symbol.SUCCESS);
            case PROFICIENCY_4:
            case PROFICIENCY_5:
                return new ResultPool(Symbol.SUCCESS, Symbol.SUCCESS);
            case PROFICIENCY_6:
                return new ResultPool(Symbol.ADVANTAGE);
            case PROFICIENCY_7:
            case PROFICIENCY_8:
            case PROFICIENCY_9:
                return new ResultPool(Symbol.SUCCESS, Symbol.ADVANTAGE);
            case PROFICIENCY_10:
            case PROFICIENCY_11:
                return new ResultPool(Symbol.ADVANTAGE, Symbol.ADVANTAGE);
            case PROFICIENCY_12:
                return new ResultPool(Symbol.TRIUMPH);
            case CHALLENGE_1:
                return new ResultPool();
            case CHALLENGE_2:
            case CHALLENGE_3:
                return new ResultPool(Symbol.FAILURE);
            case CHALLENGE_4:
            case CHALLENGE_5:
                return new ResultPool(Symbol.FAILURE, Symbol.FAILURE);
            case CHALLENGE_6:
            case CHALLENGE_7:
                return new ResultPool(Symbol.THREAT);
            case CHALLENGE_8:
            case CHALLENGE_9:
                return new ResultPool(Symbol.FAILURE, Symbol.THREAT);
            case CHALLENGE_10:
            case CHALLENGE_11:
                return new ResultPool(Symbol.THREAT, Symbol.THREAT);
            case CHALLENGE_12:
                return new ResultPool(Symbol.DESPAIR);
            case BOOST_1:
            case BOOST_2:
                return new ResultPool();
            case BOOST_3:
                return new ResultPool(Symbol.ADVANTAGE, Symbol.ADVANTAGE);
            case BOOST_4:
                return new ResultPool(Symbol.ADVANTAGE);
            case BOOST_5:
                return new ResultPool(Symbol.SUCCESS, Symbol.ADVANTAGE);
            case BOOST_6:
                return new ResultPool(Symbol.SUCCESS);
            case SETBACK_1:
            case SETBACK_2:
                return new ResultPool();
            case SETBACK_3:
            case SETBACK_4:
                return new ResultPool(Symbol.FAILURE);
            case SETBACK_5:
            case SETBACK_6:
                return new ResultPool(Symbol.THREAT);
            case FORCE_1:
            case FORCE_2:
            case FORCE_3:
            case FORCE_4:
            case FORCE_5:
            case FORCE_6:
                return new ResultPool(Symbol.DARK_SIDE);
            case FORCE_7:
                return new ResultPool(Symbol.DARK_SIDE, Symbol.DARK_SIDE);
            case FORCE_8:
            case FORCE_9:
                return new ResultPool(Symbol.LIGHT_SIDE);
            case FORCE_10:
            case FORCE_11:
            case FORCE_12:
                return new ResultPool(Symbol.LIGHT_SIDE, Symbol.LIGHT_SIDE);
            default:
                return new ResultPool();
        }
    }
}




