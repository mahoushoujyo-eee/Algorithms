package exercise;

public class TopK<Key extends Comparable<Key>> {
    public TopK() {

    }

    public TopK(Key[] a) {

    }

    public void searchK(Key[] a, int k)
    {

    }



    private int partition(Key[] a, int low, int high)
    {
        Key v = a[low];
        int i = low + 1;
        int j = high;

        while (true)
        {
            if (i > j)
            {
                exch(a, low, j);
                break;
            }
            if (less(a[i], v)) i++;
            else
            {
                exch(a, i, j--);
            }
        }
        return j;
    }

    private boolean less(Key v, Key w)
    {
        return v.compareTo(w) < 0;
    }

    private void exch(Key[] a, int i, int j)
    {
        Key tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }
}
