package Chapter2;

public class MinPQ<Key extends Comparable<Key>>
{
    Key[] data;
    int N = 0;

    public MinPQ()
    {
        data = (Key[]) new Object[1];
    }

    public MinPQ(int max)
    {
        data = (Key[]) new Object[max];
        N = max;
    }

    public MinPQ(Key[] a)
    {
        data = a;
        N = a.length;
    }

    public void insert(Key v)
    {
        if (data.length <= N)
            doubleArray();

        data[N++] = v;

    }

    public Key min()
    {
        if (isEmpty())
            return null;

        Key min = data[0];

        for (Key ele: data)
        {
            if (ele.compareTo(min) < 0)
                min = ele;
        }

        return min;
    }

    public Key delMin()
    {
        if (isEmpty())
            return null;
        Key min = min();
        if (N - 1 < data.length / 2)
            halfArray();

        N--;
        return min;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void doubleArray()
    {
        Key[] newArray = (Key[]) new Object[2 * data.length];
        int count = 0;
        for (Key ele: data)
            newArray[count++] = ele;

        data = newArray;
    }

    public void halfArray()
    {
        Key[] newArray = (Key[]) new Object[data.length / 2 + 1];
        for (int i = 0; i < newArray.length; i++)
            newArray[i] = data[i];

        data = newArray;
    }
}
