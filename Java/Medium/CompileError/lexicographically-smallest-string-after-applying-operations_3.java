class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        Set<String> set = new HashSet<>();
        set.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String res = s;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            String add = add(cur, a);
            String rotate = rotate(cur, b);
            if (set.add(add)) {
                queue.offer(add);
            }
            if (set.add(rotate)) {
                queue.offer(rotate);
            }
            res = res.compareTo(cur) < 0 ? res : cur;
        }
        return res;
    }

    private String add(String s, int a) {
        char[] chs = s.toCharArray();
        for (int i = 1; i < chs.length; i += 2) {
            chs[i] = (char) ((chs[i] - '0' + a) % 10 + '0');
        }
        return new String(chs);
    }
}