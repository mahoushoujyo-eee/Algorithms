package Chapter4;

import Chapter1.Queue;
import Chapter1.Stack;

public class DepthFirstOrder
{
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G)
    {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
        {
            if (!marked[v]) depthFirstSearch(G, v);
        }
    }

    private void depthFirstSearch(Digraph G, int v)
    {
        pre.enqueue(v);

        marked[v] = true;
        for (int w: G.adj(v))
            if (!marked[w])
                depthFirstSearch(G, w);

        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> reversePost()
    {
        return reversePost;
    }
}
