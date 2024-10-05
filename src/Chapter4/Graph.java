package Chapter4;

import java.util.ArrayList;

public class Graph
{
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();

    }

    public Graph(String input)
    {
        this(Integer.parseInt(input.charAt(0)+""));
        String[] inputs = input.split(" ");
        int[] nums = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++)
        {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        for (int i = 2; i < nums.length; i+=2)
        {
            addEdge(nums[i], nums[i+1]);
        }
    }


    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }

    @Override
    public String toString()
    {
        String s = V + "vertices" + E + "edges\n";
        for (int v = 0; v < V; v++)
        {
            s += v + ":";
            for (int w: adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
}
