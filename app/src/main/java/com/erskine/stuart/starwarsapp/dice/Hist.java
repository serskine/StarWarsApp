package com.erskine.stuart.starwarsapp.dice;

import android.support.annotation.NonNull;

import com.erskine.stuart.starwarsapp.dice.pools.ResultPool;
import com.erskine.stuart.starwarsapp.dice.results.Face;
import com.erskine.stuart.starwarsapp.dice.results.Symbol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by stuart.erskine on 2017-12-28.
 */

public class Hist<KeyType> implements Map<KeyType, Long>, Serializable {

    public long defaultValue = 0L;
    private long sum = 0L;

    private final Map<KeyType, Long> iMap;

    public Hist(KeyType... items)                             {   this(0L, items);   }
    public Hist(long defaultValue, KeyType... items)          {   this(null, defaultValue, items);   }
    public Hist(Comparator<KeyType> cmp, KeyType... items)    {   this(cmp, 0L, items);  }
    public Hist(Comparator<KeyType> cmp, long defaultValue, KeyType... items) {
        this.iMap = Collections.synchronizedMap(new TreeMap<KeyType, Long>(cmp));
        this.defaultValue = defaultValue;
        this.sum = defaultValue;
        iMap.clear();
        increment(items);
    }

    public long count(KeyType key) {
        Long value = get(key);
        if (value==null) {
            return defaultValue;
        } else {
            return value;
        }
    }

    @Override
    public int size() {
        return iMap.size();
    }

    @Override
    public boolean isEmpty() {
        return iMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return iMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return iMap.containsValue(value);
    }

    @Override
    public Long get(Object key) {
        Long current = iMap.get(key);
        if (current==null) {
            return defaultValue;
        } else {
            return current;
        }
    }

    public Hist<KeyType> set(KeyType key, Long value) {
        put(key, value);
        return this;
    }

    @Override
    public Long put(KeyType key, Long value) {
        Long current = get(key);
        sum -= current;
        sum += value;
        if (value == defaultValue || value==null) {
            iMap.remove(key);
        } else {
            iMap.put(key, value);
        }
        return current;
    }

    @Override
    public Long remove(Object key) {
        Long current = get(key);
        sum -= current;
        iMap.remove(key);
        return current;
    }

    @Override
    public void putAll(@NonNull Map<? extends KeyType, ? extends Long> m) {
        for(KeyType key : m.keySet()) {
            put(key, m.get(key));
        }
    }

    @Override
    public void clear() {
        sum = defaultValue;
        iMap.clear();
    }

    @NonNull
    @Override
    public Set<KeyType> keySet() {
        return iMap.keySet();
    }

    @NonNull
    @Override
    public Collection<Long> values() {
        return iMap.values();
    }

    @NonNull
    @Override
    public Set<Entry<KeyType, Long>> entrySet() {
        return iMap.entrySet();
    }

    public Hist<KeyType> increment(KeyType key, long amount) {
        put(key, get(key) + amount);
        return this;
    }

    public Hist<KeyType> increment(KeyType... keys) {
        if (keys!=null) {
            for (KeyType key : keys) {
                increment(key, 1);
            }
        }
        return this;
    }

    public Hist<KeyType> decrement(KeyType key, long amount) {
        put(key, get(key) - amount);
        return this;
    }

    public Hist<KeyType> decrement(KeyType... keys) {
        for(KeyType key : keys) {
            increment(key, 1L);
        }
        return this;
    }

    public Hist<KeyType> increment(Map<KeyType, ? extends Number> m) {
        for(KeyType key : m.keySet()) {
            increment(key, m.get(key).longValue());
        }
        return this;
    }

    public Hist<KeyType> decrement(Map<KeyType, ? extends Number> m) {
        for(KeyType key : m.keySet()) {
            decrement(key, m.get(key).longValue());
        }
        return this;
    }

    public Hist<KeyType> invert() {
        this.defaultValue = -defaultValue;
        for(KeyType key : keySet()) {
            put(key, -count(key));
        }
        return this;
    }

    public long getSum() {
        return sum;
    }

    public KeyType chooseRandom() {
        long value = (long) (Math.random() * getSum());
        long area = 0L;
        for(KeyType key : keySet()) {
            area += get(key);
            if (area >= value) {
                return key;
            }
        }
        throw new RuntimeException("Failed to randomly choose an item from a histogram of " + size() + " items.");
    }

    public long getMin() {
        long min = defaultValue;
        for(Long value : values()) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public long getMax() {
        long max = defaultValue;
        for(Long value : values()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public String graph() {
        return graph(keySet());
    }

    public String graph(KeyType... keys) {
        ArrayList<KeyType> theKeys = new ArrayList<>();
        for(int i=0; i<keys.length; i++) {
            theKeys.add(keys[i]);
        }
        return graph(theKeys);
    }

    public String graph(Collection<KeyType> keys) {
        String output = "";
        int keyLen = 0;
        for(KeyType key : keys) {
            keyLen = Math.max(keyLen, key.toString().length());
        }

        String divider = " | ";
        String header = "";
        String footer = "";

        // Build the header line
        for(int i=0; i<keyLen + divider.length() + getMax(); i++) {
            header += "_";
            footer += "=";
        }
        output += header + "\n";

        // Build each histogram line
        for(KeyType key : keys) {
            final String keyStr = key.toString();
            output += keyStr;
            for(int i=keyStr.length(); i<keyLen; i++) {
                output += " ";
            }
            output += divider;
            for(int i=0; i<get(key); i++) {
                output += "#";
            }
            output += "\n";
        }

        // Add the footer
        output += footer + "\n";
        return output;
    }
}



