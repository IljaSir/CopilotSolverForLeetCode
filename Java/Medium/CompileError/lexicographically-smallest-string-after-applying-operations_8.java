class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        String res = s;
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        Set<String> seen = new HashSet<>();
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (seen.add(cur)) {
                res = res.compareTo(cur) < 0 ? res : cur;
                q.offer(add(cur, a));
                q.offer(rotate(cur, b));
            }
        }
        return res;
    }
    private String add(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
        }
        return new String(arr);
    }
}