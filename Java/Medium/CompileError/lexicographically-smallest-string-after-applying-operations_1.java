class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        Set<String> visited = new HashSet<>();
        visited.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String res = s;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            res = res.compareTo(cur) < 0 ? res : cur;
            String next1 = add(cur, a);
            if (!visited.contains(next1)) {
                visited.add(next1);
                queue.offer(next1);
            }
            String next2 = rotate(cur, b);
            if (!visited.contains(next2)) {
                visited.add(next2);
                queue.offer(next2);
            }
        }
        return res;
    }

    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] += a;
            if (chars[i] > '9') {
                chars[i] -= 10;
            }
        }
        return new String(chars);
    }
}