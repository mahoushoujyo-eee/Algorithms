package exercise;

public class TopKByPriorQueue<Key extends Comparable<Key>>
{
    public Key[] a;
    public int N;

    public TopKByPriorQueue(Key[] a)
    {
        this.a = a;
        this.N = a.length;
    }

    public Key topK(int k)
    {
        PriorQueueByHeap<Key> priorQueueByHeap = new PriorQueueByHeap<>();

        for (int i = 1; i <= k+1; i++) // k + 1   --- log 1 + log 2 + log 3 + ... + log (k + 1) 各自向下取整后求和 -> log(k (k + 2) / 2)
        {
            priorQueueByHeap.insert(a[i]);
        }

        for (int i = k+2; i < N; i++)  // n - (k + 1)
        {
            priorQueueByHeap.delMin();
            priorQueueByHeap.insert(a[i]);
        }

        priorQueueByHeap.delMin();
        return priorQueueByHeap.delMin();
    }
}
