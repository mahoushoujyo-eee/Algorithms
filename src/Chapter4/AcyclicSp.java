package Chapter4;

public class AcyclicSp
{
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSp(EdgeWeightedDigraph G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        Topological top = new Topological();

        for (int v: top.order())
            relax(G, v);
    }

    private void relax(EdgeWeightedDigraph G, int v)
    {

    }
}
