package exercise;

public class PriorQueueByHeap<Key extends Comparable<Key>>
{
    public Key[] pq;
    public int N;

    public PriorQueueByHeap()
    {
        pq = (Key[]) new Comparable[20];
        N = 0;
    }

    public void insert(Key key)  // log n
    {
        pq[++N] = key;
        swim(N);
    }

    public Key delMin()
    {
        Key min = pq[1];
        exch(1, N);
        pq[N--] = null;
        sink(1);
        return min;
    }

    private void swim(int i)  // 4 log i向下取整
    {
        while(i > 1 && less(pq[i], pq[i/2]))
        {
            exch(i , i/2);
            i /= 2;
        }
    }

    private void sink(int i)  // log i
    {
        while (2 * i <= N)
        {
            int j = 2 * i;
            if (j < N && more(pq[j], pq[j+1])) j++;
            if (less(pq[i], pq[j])) break;
            exch(i ,j);
            i = j;
        }
    }

    private boolean less(Key v, Key w)
    {
        return v.compareTo(w) < 0;
    }

    private boolean more(Key v, Key w)
    {
        return !less(v, w);
    }

    private void exch(int i, int j)
    {
        Key tem = pq[i];
        pq[i] = pq[j];
        pq[j] = tem;
    }


}
