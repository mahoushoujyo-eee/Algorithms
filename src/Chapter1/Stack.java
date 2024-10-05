package Chapter1;


import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>
{
    private Node first;
    private int N;


    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>()
        {

            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public Item next() {
                return pop();
            }
        };
    }

    private class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty(){ return first == null; }
    public int size(){ return N;}
    public void push(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

}
