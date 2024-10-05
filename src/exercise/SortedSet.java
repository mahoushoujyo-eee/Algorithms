package exercise;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class SortedSet<T extends Comparable<T>> implements Collection<T>
{
    private Comparable<T>[] elements;
    private int N;

    public SortedSet()
    {
        elements = (Comparable<T>[]) new Comparable[10];
        N = 0;
    }

    public SortedSet(Comparable<T>[] c)
    {
        elements = c;
        N = c.length;
    }


    @Override
    public int size()
    {
        return N;
    }

    @Override
    public boolean isEmpty()
    {
        return N == 0;
    }

    @Override
    public boolean contains(Object o)
    {
        for (int i = 0; i < N; i++)
        {
            if (elements[i] != null && elements[i].equals(o))
                return true;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>()
        {
            private int index = 0;
            @Override
            public boolean hasNext()
            {
                return index < N;
            }

            @Override
            public T next()
            {
                return (T) elements[index++];
            }
        };
    }

    @Override
    public Object[] toArray()
    {
        return elements;
    }

    @Override
    public <T1> T1[] toArray(T1[] a)
    {
        T1[] temp = (T1[]) new Object[N+a.length];
        for (int i = 0; i < a.length; i++)
        {
            temp[i] = a[i];
        }
        for (int i = 0; i < N; i++)
        {
            temp[i+a.length] = (T1) elements[i];
        }
        return temp;
    }

    @Override
    public boolean add(T t)
    {
        if (N >= elements.length)
        {
            Comparable<T>[] temp = (Comparable<T>[]) (new Comparable[2 * elements.length]);
            for (int i = 0; i < N; i++)
            {
                temp[i] = elements[i];
            }
            elements = temp;
        }


        if (!contains(t))
        {
            int index = N;
            for (int i = 0; i < N; i++)
            {
                index = N;
                if (t.compareTo((T) elements[i]) < 0)
                {
                    index = i;
                    break;
                }
            }
            insert(index, t);
            return true;
        }


        return false;
    }

    @Override
    public boolean remove(Object o)
    {
        if (N < elements.length / 2)
        {
            Comparable<T>[] temp = (Comparable<T>[]) new Comparable[elements.length / 2];
            for (int i = 0; i < N; i++)
            {
                temp[i] = elements[i];
            }
            elements = temp;
        }

        for (int i = 0; i < N; i++)
        {
            if (elements[i] != null && elements[i].equals(o))
            {
                for (int j = i + 1; j < N; j++)
                {
                    elements[j-1] = elements[j];
                }
                elements[N-1] = null;
                N--;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        for (Object o : c)
            if (!contains(o))
                return false;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        boolean changed = false;
        for (T t : c)
        {
            if (t != null && add(t))
                changed = true;
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        boolean changed = false;

        for (Object o : c)
        {
            if (o != null && remove(o))
                changed = true;
        }

        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        SortedSet<T> tempSet = new SortedSet<>();

        for (Object o : elements)
        {
            if (c.contains(o))
                tempSet.add((T) o);
        }

        elements = tempSet.elements;
        N = tempSet.size();
        return true;
    }

    @Override
    public void clear()
    {
        N = 0;
        elements = (T[]) new Object[10];
    }

    private void insert(int index, T element)
    {
        for (int i = N; i > index; i--)
        {
            elements[i] = elements[i-1];
        }

        elements[index] = element;
        N++;
    }

    public boolean isProperSubsetOf(SortedSet<T> set)
    {
        if (N == set.size())
            return false;

        return isSubsetOf(set);
    }

    public boolean isProperSupersetOf(SortedSet<T> set)
    {
        if (N == set.size())
            return false;

        return isSupersetOf(set);
    }

    public boolean isSubsetOf(SortedSet<T> set)
    {
        for (int i = 0; i < N; i++)
            if (!set.contains(elements[i]))
                return false;

        return true;
    }

    public boolean isSupersetOf(SortedSet<T> set)
    {
        for (Object o : set.elements)
        {
            if(o != null && !contains(o))
                return false;
        }

        return true;
    }

    public boolean isOverlapped(SortedSet<T> set)
    {
        if (N != set.size())
            return false;

        for (int i = 0; i < N; i++)
            if (set.get(i) != elements[i])
                return false;

        return true;
    }

    public boolean setEquals(SortedSet<T> set)
    {
        for (Comparable<T> t : set.elements)
        {
            if (set.contains(t))
                return true;
        }

        return false;
    }

    public void symmetricExceptWith(SortedSet<T> set)
    {
        Comparable<T>[] temp = (Comparable<T>[]) new Comparable[set.size() + size()];
        int tempIndex = 0;
        for (int i = 0; i < set.size(); i++)
        {
            if (contains(set.get(i)))
            {
                remove(set.get(i));
                temp[tempIndex++] = set.get(i);
            }
        }
        for (Comparable<T> t : temp)
        {
            set.remove(t);
        }

        addAll(set);
    }

    public void intersectionWith(SortedSet<T> set)
    {
        Comparable<T>[] temp = (Comparable<T>[]) new Comparable[set.size()];
        int tempIndex = 0;
        for (int i = 0; i < N; i++)
        {
            if (set.contains(elements[i]) && contains(elements[i]))
                temp[tempIndex++] = elements[i];
        }
        elements = temp;
        N = temp.length;
    }

    public void unionWith(SortedSet<T> set)
    {
        Comparable<T>[] temp = (Comparable<T>[]) new Comparable[set.size() + size()];
        int tempIndex = 0;
        for (int i = 0; i < N; i++)
        {
            temp[tempIndex++] = elements[i];
        }

        for (int i = 0; i < set.size(); i++)
        {
            add(set.get(i));
        }
    }

    public T get(int index)
    {
        return (T) elements[index];
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++)
        {
            if (elements[i] != null)
                sb.append(elements[i] + " ");
        }
        return sb.toString();
    }
}