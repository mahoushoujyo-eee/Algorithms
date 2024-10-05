package Chapter2;

import Chapter1.Stack;

import java.util.Scanner;

public class TopM
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int M = Integer.parseInt(args[0]);
        MinPQ<Integer> pq = new MinPQ<>();
        while (input.hasNext())
        {
            pq.insert(new Integer(input.nextInt()));
            if (pq.size() > M)
                pq.delMin();
        }

        Stack<Integer> stack = new Stack<>();
        while(!pq.isEmpty()) stack.push(pq.delMin());
        for (Integer t: stack) System.out.println(t);
    }
}
