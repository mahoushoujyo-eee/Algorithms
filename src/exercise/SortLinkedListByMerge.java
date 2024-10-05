package exercise;

import java.util.Random;

public class SortLinkedListByMerge
{
    private static Comparable[] aux;

    public static void main(String[] args)
    {
        //4  O(1)
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> last = new LinkedList<>();
        LinkedList<Integer> pre = new LinkedList<>();
        LinkedList<Integer> now = new LinkedList<>();
        Random random = new Random();

        //3 * n    O(n)
        for (int i = 0; i < 5; i++)
        {
            now = new LinkedList<>(random.nextInt(10));

            if (i == 0) {
                first = now;
                pre = now;
            } else if (i == 4) {
                pre.next = now;
                last = now;
            } else {
                pre.next = now;
                pre = now;
            }
        }

        ReverseLinkedList.showLinkedList(first);
        Integer[] numbers = new Integer[ReverseLinkedList.getLinkedListLength(first)];

        int count = 0;
        for (LinkedList<Integer> node = first; node != null; node = node.next)
            numbers[count++] = node.t;

        sort(numbers);

        count = 0;

        for (LinkedList<Integer> node = first; node != null; node = node.next)
            node.t = numbers[count++];

        ReverseLinkedList.showLinkedList(first);

    }

    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
        {
            if (i > mid)                a[k] = aux[j++];
            else if(j > hi)             a[k] = aux[i++];
            else if (less(a[i], a[j]))  a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }
}
