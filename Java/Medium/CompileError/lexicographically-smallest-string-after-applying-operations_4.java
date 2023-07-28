class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        Set<String> set = new HashSet<>();
        set.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String res = s;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            String next = add(cur, a);
            if (set.add(next)) {
                queue.offer(next);
            }
            next = rotate(cur, b);
            if (set.add(next)) {
                queue.offer(next);
            }
            if (next.compareTo(res) < 0) {
                res = next;
            }
        }
        return res;
    }
    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
        }
        return new String(chars);
    }
}