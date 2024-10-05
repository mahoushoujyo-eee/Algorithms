package exercise;

public class LinkedList<T>
{
    public T t;
    public LinkedList<T> next;

    public LinkedList(T t, LinkedList<T> next)
    {
        this.t = t;
        this.next = next;
    }

    public LinkedList()
    {
    }

    public LinkedList(T t)
    {
        this.t = t;
    }

    public static void exch()
    {

    }
}
