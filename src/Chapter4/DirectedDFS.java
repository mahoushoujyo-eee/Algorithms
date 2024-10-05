package Chapter4;

public class DirectedDFS
{
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s)
    {
        marked = new boolean[G.V()];
        depthFirstSearch(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources)
    {
        marked = new boolean[G.V()];
        for (int s : sources)
            if (!marked[s]) depthFirstSearch(G, s);
    }

    private void depthFirstSearch(Digraph G, int v)
    {
        marked[v] = true;
        for (int w: G.adj(v))
            if (!marked[w]) depthFirstSearch(G,w);
    }

    public boolean marked(int v)
    {
        return marked[v];
    }
}
