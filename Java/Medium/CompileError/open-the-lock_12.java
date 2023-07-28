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
            depth++;
        }
        return -1;
    }
    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') ch[j] = '0';
        else ch[j]++;
        return new String(ch);
    }
}