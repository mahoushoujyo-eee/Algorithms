package Chapter4;

public class Search
{
    private Graph G;
    private int s;


    public Search(Graph G, int s)
    {
        this.G = G;
        this.s = s;
    }

    public boolean marked(int v)
    {
        return false;
    }

    public int count()
    {
        return 0;
    }
}
