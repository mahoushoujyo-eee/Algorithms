package Chapter5;

import Chapter2.Insertion;

public class MSD
{
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;

    private static int charAt(String s, int d)
    {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a)
    {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    private static void sort(String[] a, int low, int high, int d)
    {
        if (high <= low + M)
        {
            Insertion.sort(a);
            return;
        }

        int[] count = new int[R+2];
        for (int i = low; i <= high; i++)
            count[charAt(a[i], d)+2]++;

        for (int r = 0; r < R+1; r++)
            count[r+1] = count[r];

        for (int i = low; i <= high; i++)
            aux[count[charAt(a[i], d)+1]++] = a[i];

        for (int i = low; i <= high; i++)
            a[i] = aux[i - low];

        for (int r = 0; r < R; r++)
            sort(a, low+count[r], low+count[r+1]-1, d+1);
    }
}
