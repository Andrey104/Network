package com.company;

import java.util.ArrayList;

/**
 * Created by Андрей on 11.04.2017.
 */
public class BitArray {
    private ArrayList<Boolean> array = new ArrayList<>();

    public BitArray(int length) {
        for (int i = 0; i < length; i++) {
            array.add(Boolean.FALSE);
        }
    }

    public BitArray put(byte[] b) {
        for (int i = 0; i < array.size(); i++) {
            array.set(i, ((b[i / 8] >>> (i % 8)) & 1) == 1);
        }
        return this;
    }
}
