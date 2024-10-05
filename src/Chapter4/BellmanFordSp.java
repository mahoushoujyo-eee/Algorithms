package Chapter4;

import Chapter1.Queue;

public class BellmanFordSp
{
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost;
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSp(EdgeWeightedDigraph G, int s)
    {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle())
        {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private boolean hasNegativeCycle()
    {
        return false;
    }

    private void relax(EdgeWeightedDigraph G, int v)
    {
        for (DirectedEdge edge: G.adj(v))
        {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (!onQ[w])
                {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0)
                findNegativeCycle();

        }
    }

    private void findNegativeCycle()
    {

    }
}
