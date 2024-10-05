package exercise;

public class ReverseLinkedList {
    public static void main(String[] args) {

        //4  O(1)
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> last = new LinkedList<>();
        LinkedList<Integer> pre = new LinkedList<>();
        LinkedList<Integer> now = new LinkedList<>();

        //3 * n    O(n)
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

        // n + 1
        showLinkedList(first);
        // n + 1   O(n)
        int length = getLinkedListLength(first);


        //2  O(1)
        LinkedList<Integer> newFirst = last;
        LinkedList<Integer> newLast = first;

        //(n - 1) * 2  +  (1 + 2 + 3 + ... + n - 1) -> (n - 1) * n / 2  O(n) + O(n^2)
        for (int i = length - 1; i >= 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (j == 0)
                    now = first;
                else
                    now = now.next;
            }
            if (i == length - 1)
            {
                newFirst.next = now;
                pre = now;
            }
            else if (i == 1)
            {
                newLast = now;
                newLast.next = null;
                pre.next = now;
            }
            else
            {
                pre.next = now;
                pre = now;
            }
        }
        // n + 1  O(n)
        showLinkedList(newFirst);

    }


    public static void showLinkedList(LinkedList first) {
        for (LinkedList node = first; node != null; node = node.next)
            System.out.print(node.t + " ");
        System.out.println();
    }

    public static int getLinkedListLength(LinkedList first)
    {
        int count = 0;
        for (LinkedList node = first; node != null; node = node.next)
            count++;
        return count;
    }

}
