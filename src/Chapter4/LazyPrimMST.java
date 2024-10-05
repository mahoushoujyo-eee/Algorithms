package Chapter4;

import Chapter1.Queue;
import Chapter2.MinPQ;

public class LazyPrimMST
{
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G)
    {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G, 0);
        while (!pq.isEmpty())
        {
            Edge edge = pq.delMin();

            int v = edge.either(), w = edge.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(edge);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }


    }

    private void visit(EdgeWeightedGraph G, int v)
    {
        marked[v] = true;
        for (Edge edge: G.adj(v))
            if (!marked[edge.other(v)]) pq.insert(edge);
    }
}
