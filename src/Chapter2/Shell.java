package Chapter2;

public class Shell
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while(h < N / 3) h = 3 * h + 1;
        while (h >= 1)
        {
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h /= 3;
        }

    }

    public static boolean less(Comparable i, Comparable j)
    {
        return i.compareTo(j) < 0;
    }

    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
