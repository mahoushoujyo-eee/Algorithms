//package Chapter4;
//
//import Chapter2.MinPQ;
//
//public class PrimMST
//{
//    private Edge[] edgeTo;
//    private double[] distTo;
//    private boolean[] marked;
//    private MinPQ<Double> pq;
//
//    public PrimMST(EdgeWeightedGraph G)
//    {
//        edgeTo = new Edge[G.V()];
//        distTo = new double[G.V()];
//        marked = new boolean[G.V()];
//        for (int v = 0; v < G.V(); v++)
//            distTo[v] = Double.POSITIVE_INFINITY;
//        pq = new MinPQ<>(G.V());
//
//        distTo[0] = 0.0;
//        pq.insert(0, 0.0);
//        while (!pq.isEmpty())
//            visit(G, pq.delMin());
//    }
//
//    private void visit(EdgeWeightedGraph G, int v)
//    {
//        marked[v] = true;
//        for (Edge edge: G.adj(v))
//        {
//            int w = edge.other(v);
//
//            if (marked[w]) continue;
//            if (edge.weight() < distTo[w])
//            {
//                edgeTo[w] = edge;
//
//                distTo[w] = edge.weight();
//                if (pq.contains(w)) pq.change(w, distTo[w]);
//                else pq.insert(w, distTo[w]);
//            }
//        }
//    }
//}
