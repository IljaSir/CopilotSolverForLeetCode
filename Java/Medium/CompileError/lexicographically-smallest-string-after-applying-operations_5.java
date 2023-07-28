class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String res = s;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (!visited.contains(cur)) {
                res = res.compareTo(cur) < 0 ? res : cur;
                visited.add(cur);
                queue.offer(add(cur, a));
                queue.offer(rotate(cur, b));
            }
        }
        return res;
    }
    
    private String add(String s, int a) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i += 2) {
            ch[i] = (char)((ch[i] - '0' + a) % 10 + '0');
        }
        return new String(ch);
    }
}