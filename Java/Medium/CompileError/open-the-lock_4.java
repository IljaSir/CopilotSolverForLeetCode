class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> dead = new HashSet<>();
        for (String d: deadends) dead.add(d);
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (dead.contains(cur)) continue;
                if (cur.equals(target)) return step;
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') ch[j] = '0';
        else ch[j] += 1;
        return new String(ch);
    }
}