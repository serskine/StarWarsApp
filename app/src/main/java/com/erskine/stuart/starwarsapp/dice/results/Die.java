package com.erskine.stuart.starwarsapp.dice.results;

import com.erskine.stuart.starwarsapp.R;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public enum Die {
    ABILITY     (8, "(D)", R.string.die_ability, R.drawable.green),
    DIFFICULTY  (8, "(d)", R.string.die_difficulty, R.drawable.purple),
    PROFICIENCY (12, "(C)", R.string.die_proficiency, R.drawable.yellow),
    CHALLENGE   (12, "(c)", R.string.die_challenge, R.drawable.red),
    BOOST       (6, "(B)", R.string.die_boost, R.drawable.blue),
    SETBACK     (6, "(b)", R.string.die_setback, R.drawable.black),
    FORCE       (6, "(B)", R.string.die_force, R.drawable.white);

    public final int numFaces;
    public final String code;
    public final int text;
    public final int icon;

    Die(int numFaces, String code, int text, int icon) {
        this.numFaces = numFaces;
        this.code = code;
        this.text = text;
        this.icon = icon;
    }

}
