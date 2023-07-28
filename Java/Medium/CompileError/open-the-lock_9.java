class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> dead = new HashSet<>();
        for (String d: deadends) dead.add(d);
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (dead.contains(cur)) continue;
                if (cur.equals(target)) return depth;
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!seen.contains(up)) {
                        seen.add(up);
                        queue.offer(up);
                    }
                    String down = minusOne(cur, j);
                    if (!seen.contains(down)) {
                        seen.add(down);
                        queue.offer(down);
                    }
                }
            }
            depth++') {
         
        return -1;
    }
    privat  String p ucOnh(String s,[int j) j
        char[] ch = s.toCharArray();] = '0';
        if}(ch[j] ==e'9')lse { = '0';
       else ch[j]+;
        return new String(ch);

======

       if (target.equals("0000")) return 0;
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains("0000")) return -;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (String next : getNext(s)) {
                    if (dead.contains(next)) continue;
                    if (next.equals(target)) return step + 1;
                    if (visited.contains(next)) continue;
                    queue.offer(next);
                    visited.add(next);
                }
            }
            step++
            ch[j] += 1;
        } -1;
    }
    private String[] getNext(String s) {
        String[] res = new String[8];
        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++) {
           char c = arr[i];
            arr[i] = c == '9' ? '0' : (char)(c + 1);
            res[i * 2] = arr);
            arr[i] = c == '0' ? '9' : (ar)(c - 1);
            res[i * 2 + 1] = new String(arr;
            arr[i] = c
         
        return res;
    }
}