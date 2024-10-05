//package Chapter5;
//
//
//import Chapter1.Queue;
//
//public class TrieST<Value>
//{
//    private static int R = 256;
//    private Node root;
//
//    private static class Node
//    {
//        private Object value;
//        private Node[] next = new Node[R];
//    }
//
//    public Value get(String key)
//    {
//        Node x = get(root, key, 0);
//        if (x == null) return null;
//        return (Value) x.value;
//    }
//
//    private Node get(Node x, String key, int d)
//    {
//        if (x == null) return null;
//        if (d == key.length()) return x;
//        char c = key.charAt(d);
//        return get(x.next[c], key, d+1);
//    }
//
//    public void put(String key, Value value)
//    {
//        root = put(root, key, value, 0);
//    }
//
//    private Node put(Node x, String key, Value value, int d)
//    {
//        if (x == null) x = new Node();
//        if (d == key.length())
//        {
//            x.value = value;
//            return x;
//        }
//        char c = key.charAt(d);
//        x.next[c] = put(x.next[c], key, value, d+1);
//        return x;
//    }
//
//    public Iterable<String> keys()
//    {
//        return keysWithPrefix("");
//    }
//
//    public Iterable<String> keysWithPrefix(String pre)
//    {
//        Queue<String> q = new Queue<>();
//        collect(get(root, pre, 0), pre, q);
//        return q;
//    }
//
//    private void collect(Node x, String pre, Queue<String> q)
//    {
//        if (x == null) return;
//        if (x.value != null) q.enqueue(pre);
//        for (char c = 0; c < R; c++)
//            collect(x.next[c], pre+c, q);
//    }
//
//    public Iterable<String> keysThatMatch(String pat)
//    {
//        Queue<String> queue = new Queue<>();
//        collect(root, "", pat, queue);
//        return queue;
//    }
//
//    private void collect(Node x, String pre, String pat, Queue<String> queue)
//    {
//        int d = pre.length();
//        if (x == null) return;
//        if (d == pat.length() && x.value != null) queue.enqueue(pre);
//        if (d == pat.length()) return;
//
//        char next = pat.charAt(d);
//        for (char c = 0; c < R; c++)
//            if (next == '.' || next == c)
//                collect(x.next[c], pre+c, pat, queue);
//    }
//
//    public void delete(String key)
//    {
//        root = delete(root, key, 0);
//    }
//
//    private Node delete(Node x, String key, int d)
//    {
//        if (x == null) return null;
//        if (d == key.length())
//            x.value = null;
//        else
//        {
//            char c = key.charAt(d);
//            x.next[c] = delete(x.next[c], key, d+1);
//        }
//        if (x.value != null) return x;
//
//        for (char c = 0; c < R; c++)
//            if (x.next[c] != null) return x;
//        return null;
//    }
//}
