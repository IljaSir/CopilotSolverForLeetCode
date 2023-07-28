class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> deadss = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        visited.add("0000");();
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.addup
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        Queue.offer(down);
                        visited<Stridown);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}