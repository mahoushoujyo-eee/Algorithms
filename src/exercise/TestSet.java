package exercise;

public class TestSet
{
    //iterator isSubsetOf isSupersetOf intersectionWith containAll addAll removeAll
    public static void main(String[] args)
    {
        testSortedSet1();
    }

    private static void testSortedSet2()
    {
        SortedSet<Integer> set1 = new SortedSet<>();
        set1.add(1);
        set1.add(5);
        set1.add(4);
        set1.add(2);
        set1.add(0);
        set1.remove(1);
        set1.remove(0);
        System.out.println(set1);

        SortedSet<Integer> set2 = new SortedSet<>();
        set2.add(2);
        set2.add(5);
        set2.add(4);
        System.out.println(set2);



        System.out.println(set2.isSubsetOf(set1));
    }

    public static void testHashSet1()
    {
        HashSet<Student> set1 = new HashSet<>();
        set1.add(new Student(1, "John"));
        set1.add(new Student(2, "Jane"));
        set1.add(new Student(3, "Bob"));
        set1.add(new Student(4, "Alice"));
        set1.add(new Student(6, "MaChao"));
        System.out.println(set1);

        HashSet<Student> set2 = new HashSet<>();
        set2.add(new Student(1, "John"));
        set2.add(new Student(2, "Jane"));
        set2.add(new Student(4, "Alice"));
        set2.add(new Student(5, "Bob"));

        System.out.println(set2);

        set1.intersectionWith(set2);
        System.out.println(set1);

        for (Student student : set1)
            if (student != null)
                System.out.println(student);
    }

    public static void testHashSet2()
    {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        System.out.println(set1);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.remove(5);
        System.out.println(set2);
        System.out.println(set2.isProperSubsetOf(set1));
    }

    public static void testSortedSet1()
    {
        SortedSet<Integer> set1 = new SortedSet<>();
        set1.add(1);
        set1.add(5);
        set1.add(4);
        set1.add(3);
        set1.add(0);
        set1.remove(1);

        SortedSet<Integer> set2 = new SortedSet<>();
        set2.add(2);
        set2.add(5);
        set2.add(4);
        set2.add(0);
        set2.add(3);

        System.out.println(set1);
        System.out.println(set2);

        System.out.println(set1.containsAll(set2));
    }
}
