package com.erskine.stuart.starwarsapp.util.common;

import java.util.Map;

/**
 * Created by stuart.erskine on 2017-12-31.
 */

public class Pair<Key, Value> implements Map.Entry<Key, Value> {

    private Key key;
    private Value value;

    public Pair() {
        this(null, null);
    }
    public Pair(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Key getKey() {
        return this.key;
    }

    @Override
    public Value getValue() {
        return this.value;
    }

    @Override
    public Value setValue(Value value) {
        Value old = this.value;
        this.value = value;
        return old;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
