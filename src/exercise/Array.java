package exercise;

import Chapter2.Quick;

import java.util.ArrayList;

public class Array<Key extends Comparable<Key>>
{
    public ArrayList<Key[]> keyArrays = new ArrayList<>();
    public Key[] simples;

    public Array(Key[] simples)
    {
        this.simples = simples;
    }

    public boolean arrangeContains(Key[] keys)
    {
        for (Key[] keysData: keyArrays)
            if (arrangeEquals(keys, keysData))
                return true;

        return false;
    }

    public boolean arrangeEquals(Key[] keys1, Key[] keys2)
    {
        for (int i = 0; i < keys1.length; i++)
        {
            if (keys1[i] != keys2[i])
                return false;
        }

        return true;
    }

    public boolean combinationContains(Key[] keys)
    {
        for (Key[] keysData: keyArrays)
            if (combinationEquals(keys, keysData))
                return true;

        return false;
    }

    public boolean combinationEquals(Key[] keys1, Key[] keys2)
    {
        return arrangeEquals(sortKeys(keys1), sortKeys(keys2));
    }

    public Key[] sortKeys(Key[] keys)
    {
        Key[] cloneKeys = cloneKeys(keys);
        Quick.sort(cloneKeys);
        return cloneKeys;
    }

    private Key[] cloneKeys(Key[] keys)
    {
        Key[] newKeys = (Key[]) new Comparable[keys.length];


        int count = 0;
        for (Key key: keys)
            newKeys[count++] = key;

        return newKeys;
    }

}
