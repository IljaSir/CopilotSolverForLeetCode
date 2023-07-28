class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        String ans = s;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            ans = ans.compareTo(cur) < 0 ? ans : cur;
            String s1 = add(cur, a);
            String s2 = rotate(cur, b);
            if (!visited.contains(s1)) {
                queue.offer(s1);
                visited.add(s1);
            }
            if (!visited.contains(s2)) {
                queue.offer(s2);
                visited.add(s2);
            }
        }
        return ans;
    }
    
    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
        }
        return new String(chars);
    }
}