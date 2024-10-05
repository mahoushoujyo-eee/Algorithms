package Chapter4;

import java.util.ArrayList;
import java.util.Arrays;

public class EdgeWeightedDigraph
{
    private final int V;
    private int E;
    private ArrayList<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public void addEdge(DirectedEdge edge)
    {
        adj[edge.from()].add(edge);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v)
    {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges()
    {
        ArrayList<DirectedEdge> bag = new ArrayList<>();
        for (int v = 0; v  < V; v++)
            for (DirectedEdge edge: adj[v])
                bag.add(edge);
        return bag;
    }

}
