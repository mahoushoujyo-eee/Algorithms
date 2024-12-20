package Chapter4;

import Chapter1.Stack;

public class DirectedCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G)
    {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
        {
            if (!marked[v]) depthFirstSearch(G, v);
        }
    }

    private void depthFirstSearch(Digraph G, int v)
    {
        onStack[v] = true;
        marked[v] = true;
        for (int w: G.adj(v))
        {
            if (this.hasCycle()) return;
            else if (!marked[w])
            {
                edgeTo[w] = v;
                depthFirstSearch(G,w);
            }
            else if (onStack[w])
            {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);

                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle()
    {
        return cycle != null;
    }
}
