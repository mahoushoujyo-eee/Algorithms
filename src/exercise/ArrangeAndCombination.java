package Exercise;

import java.util.ArrayList;

public class ArrangeAndCombination<Key>
{
    public Key[] arr;
    public ArrayList<Key[]> arrList = new ArrayList<>();
    public int endCount;

    public ArrangeAndCombination(Key[] arr, int endCount)
    {
        this.arr = arr;
        this.endCount = endCount;
    }

    public void selectFromArray()
    {
        Key[] nowEle = (Key[]) new  Object[0];
        selectFromArray(arr, nowEle);
    }

    private void selectFromArray(Key[] arr, Key[] nowEle)
    {
        if (nowEle.length == endCount)
        {
            arrList.add(nowEle);
        }
        else
        {
            for (int i = 0; i < arr.length; i++)
            {
                selectFromArray(subClone(arr, arr[i]), addClone(nowEle, arr[i]));// A(m, n) * n * m
            }
        }
    }

    private Key[] clone(Key[] arr)
    {
        Key[] temp = (Key[]) new Object[arr.length];

        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i];

        return temp;
    }

    private Key[] addClone(Key[] arr, Key key)
    {
        Key[] temp = (Key[]) new Object[arr.length+1];

        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i];
        temp[arr.length] = key;

        return temp;
    }

    private Key[] subClone(Key[] arr, Key key)
    {
        Key[] temp = (Key[]) new Object[arr.length-1];
        int keyIndex = 0;

        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(key))
            {
                keyIndex = i;
                break;
            }

        int counter = 0;
        for (int i = 0; i < arr.length; i++)
        {
           if (i != keyIndex)
               temp[counter++] = arr[i];
        }

        return temp;
    }

}
