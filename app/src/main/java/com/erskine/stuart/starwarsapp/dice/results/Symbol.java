package com.erskine.stuart.starwarsapp.dice.results;

/**
 * Created by stuart.erskine on 2017-12-28.
 */


import com.erskine.stuart.starwarsapp.R;

/**
 *
 */
public enum Symbol {
    SUCCESS("(s)", R.string.face_success, R.drawable.success),
    ADVANTAGE("(a)", R.string.face_advantage, R.drawable.advantage),
    THREAT("(t)", R.string.face_threat, R.drawable.threat),
    TRIUMPH("(x)", R.string.face_triumph, R.drawable.triumph),
    DESPAIR("(y)", R.string.face_despair, R.drawable.despair),
    FAILURE("(f)", R.string.face_failure, R.drawable.failure),
    LIGHT_SIDE("(Z)", R.string.face_lightside, R.drawable.lightside),
    DARK_SIDE("(z)", R.string.face_darkside, R.drawable.darkside)
    ;



    public final String code;
    public final int text;
    public final int drawable;

    Symbol(String code, int text, int drawable) {
        this.code = code;
        this.text = text;
        this.drawable = drawable;
    }
}
