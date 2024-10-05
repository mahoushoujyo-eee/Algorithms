package exercise;

import java.util.Collection;
import java.util.Iterator;

public class HashSet<T> implements Collection<T>
{
    int N = 0;
    int M = 5;
    T[] elements;

    public HashSet()
    {
        elements = (T[]) new Object[M];
    }

    public HashSet(int size)
    {
        M = size;
        elements = (T[]) new Object[M];
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
        int i;

        for (i = hash((T)o); elements[i] != null; i = (i + 1) % M)
        {
            if (elements[i] != null && elements[i].equals(o))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private int index = 0;
            @Override
            public boolean hasNext()
            {
                return index < elements.length;
            }

            @Override
            public T next()
            {
                return elements[index++];
            }
        };
    }

    @Override
    public Object[] toArray()
    {
        return elements.clone();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t)
    {
        if (N >= M / 2) resize(nextPrimer(2*M-1));

        int i;

        for (i = hash(t); elements[i] != null; i = (i + 1) % M)
        {
            if (elements[i].equals(t))
                return false;
        }

        elements[i] = t;
        N++;

        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        int i;

        for (i = hash((T)o); elements[i] != null; i = (i + 1) % M)
        {
            if (elements[i].equals(o))
            {
                delete(i);
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
            if (o != null && !contains(o))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        for (T t : c)
            if (t != null)
                add(t);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c)
            if (o != null)
                remove(o);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        T[] temp = (T[]) new Object[c.size()];
        int index = 0;

        for (Object o : elements)
        {
            if (o != null && c.contains(o))
                temp[index++] = (T) o;
        }

        elements = temp;
        if (N == elements.length) return false;
        N = elements.length;
        return true;
    }

    @Override
    public void clear()
    {
        N = 0;
        elements = (T[]) new Object[M];
    }

    public void copyTo(T[] c, int copyIndex)
    {
        T[] copy = (T[]) new Object[N];
        System.arraycopy(elements, copyIndex, copy, 0, N);
        c = copy;
    }

    public boolean isProperSubsetOf(HashSet<T> set)
    {
        if (N == set.size())
            return false;

        return isSubsetOf(set);
    }

    public boolean isProperSupersetOf(HashSet<T> set)
    {
        if (N == set.size())
            return false;

        return isSupersetOf(set);
    }

    public boolean isSubsetOf(HashSet<T> set)
    {
        for (int i = 0; i < N; i++)
            if (elements[i] != null && !set.contains(elements[i]))
                return false;

        return true;
    }

    public boolean isSupersetOf(HashSet<T> set)
    {
        for (Object o : set.elements)
        {
            if(o != null && !contains(o))
                return false;
        }

        return true;
    }

    public boolean isOverlapped(HashSet<T> set)
    {
        if (N != set.size())
            return false;

        for (int i = 0; i < N; i++)
            if (set.get(i) != elements[i])
                return false;

        return true;
    }

    public boolean setEquals(HashSet<T> set)
    {
        for (T t : set.elements)
        {
            if (set.contains(t))
                return true;
        }

        return false;
    }

    public void intersectionWith(HashSet<T> set)
    {
        T[] temp = (T[]) new Object[M];
        int tempIndex = 0;
        for (int i = 0; i < M; i++)
        {
            if (elements[i] != null && !set.contains(elements[i]))
                temp[tempIndex++] = elements[i];
        }
        for (int i = 0; i < temp.length; i++)
            if (temp[i] != null)
                remove(temp[i]);
    }


    private void enlarge()
    {
        T[] newElements = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    private void shrink()
    {
        T[] newElements = (T[]) new Object[elements.length / 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    private void delete(int elementIndex)
    {
        elements[elementIndex] = null;
    }

    private T get(int index)
    {
        return elements[index];
    }

    private void resize(int newSize)
    {
        HashSet<T> tempSet = new HashSet<>(newSize);
        for (int i = 0; i < M; i++)
        {
            if (elements[i] != null)
                tempSet.add(elements[i]);
        }
        elements = tempSet.elements;
        N = tempSet.N;
        M = tempSet.M;
    }

    private int nextPrimer(int num)
    {
        while(!isPrimer(num+2))
        {
            num += 2;
        }

        return num+2;
    }

    private boolean isPrimer(int num)
    {
        for (int i = 2; i < Math.sqrt(num); i++)
        {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private int hash(T element)
    {
        return (element.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++)
        {
            if (elements[i] != null)
                sb.append(elements[i].toString() + " ");
        }
        return sb.toString();
    }

}
