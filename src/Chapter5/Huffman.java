package Chapter5;

import Chapter2.MinPQ;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Huffman
{
    private static int R = 256;

    private static class Node implements Comparable<Node>
    {
        private char ch;
        private int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right)
        {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf()
        {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node that)
        {
            return this.freq - that.freq;
        }
    }

    public static void compress()
    {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] inputs = s.toCharArray();

        int[] freq = new int[256];
        for (int i = 0; i < inputs.length; i++)
            freq[inputs[i]]++;

        Node root = buildTrie(freq);
        String[] st = new String[256];

        buildCode(st, root, "");

    }

    public static void expand() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Node root = readTire();
        int N = new Scanner(System.in).nextInt();
        for (int i = 0; i < N; i++)
        {
            Node x = root;
            while(!x.isLeaf())
                if (input.nextBoolean())
                    x = x.right;
                else x = x.right;

                new PrintWriter("test.txt").print(x.ch);
        }

    }

    private static Node readTire()
    {
        if (new Scanner(System.in).nextBoolean())
            return new Node('0', 0, null, null);
        return new Node('\0', 0, readTire(), readTire());
    }

    private static String[] buildCode(Node root)
    {
        String[] st = new String[256];
        buildCode(st, root, "");
        return st;
    }

    private static void buildCode(String[] st, Node x, String s)
    {
        if (x.isLeaf())
        {
            st[x.ch] = s;
            return;
        }
        buildCode(st, x.left, s + '0');
        buildCode(st, x.right, s + '1');
    }

    private static Node buildTrie(int[] freq)
    {
        MinPQ<Node> pq = new MinPQ<>();
        for (char c = 0; c < 256; c++)
            if (freq[c] > 0)
                pq.insert(new Node(c, freq[c], null, null));

        while (pq.size() > 1)
        {
            Node x = pq.delMin();
            Node y = pq.delMin();
            Node parent = new Node('\0', x.freq + y.freq, x, y);
            pq.insert(parent);
        }
        return pq.delMin();
    }
}
