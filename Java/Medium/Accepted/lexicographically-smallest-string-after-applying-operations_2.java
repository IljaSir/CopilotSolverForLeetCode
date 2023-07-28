class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        Set<String> visited = new HashSet<>();
        visited.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        String ans = s;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            ans = ans.compareTo(cur) < 0 ? ans : cur;
            String rotate = rotate(cur, b);
            if (!visited.contains(rotate)) {
                visited.add(rotate);
                queue.add(rotate);
            }
            String add = add(cur, a);
            if (!visited.contains(add)) {
                visited.add(add);
                queue.add(add);
            }
        }
        return ans;
    }

    private String rotate(String s, int b) {
        int n = s.length();
        b = b % n;
        return s.substring(n - b) + s.substring(0, n - b);
    }

    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
        }
        return new String(chars);
    }
}