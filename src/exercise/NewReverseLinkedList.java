package exercise;

public class NewReverseLinkedList
{
    public static void main(String[] args)
    {
        //4  O(1)
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> last = new LinkedList<>();
        LinkedList<Integer> pre = new LinkedList<>();
        LinkedList<Integer> now = new LinkedList<>();

        //2 * n  O(n)
        for (int i = 0; i < 5; i++)
        {
            now = new LinkedList<>(i);

            if (i == 0) {
                first = now;
                pre = now;
            } else if (i == 4) {
                pre.next = now;
                last = now;
            } else {
                pre.next = now;
                pre = now;
            }
        }

        // n + 1  O(n)
        ReverseLinkedList.showLinkedList(first);
        // n
        //int length = ReverseLinkedList.getLinkedListLength(first);

        //4 O(1)
        LinkedList<Integer> preNewFirst;
        LinkedList<Integer> newFirst = first.next;
        first.next = first.next.next;
        newFirst.next = first;

        //4 * (n - 1)  O(n)
        while (first.next != null)
        {
            preNewFirst = newFirst;
            newFirst = first.next;
            first.next = first.next.next;
            newFirst.next = preNewFirst;
        }

        //n + 1  O(n)
        ReverseLinkedList.showLinkedList(newFirst);
    }
}
