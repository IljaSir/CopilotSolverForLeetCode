class Solution {
    public boolean isTransformable(String s, String t) {
        
        int n = s.length();
        List<Deque<Integer>> pos = new ArrayList<>();
        for (int i = 0; i < 10; ++i)
            pos.add(new LinkedList<Integer>());
        for (int i = 0; i < n; ++i)
            pos.get(s.charAt(i) - '0').offer(i);
        for (char c: t.toCharArray()) {
            int d = c - '0';
            if (pos.get(d).isEmpty())
                return false;
            for (int i = 0; i < d; ++i) {
                if (!pos.get(i).isEmpty() && pos.get(i).peek() < pos.get(d).peek())
                    return false;
            }
            pos.get(d).poll();
        }
        return true;
    }
}