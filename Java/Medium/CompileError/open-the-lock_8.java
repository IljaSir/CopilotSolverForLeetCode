class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> deadEnds = new HashSet<>();
        for (String deadend : deadends) {
            deadEnds.add(deadend);
        }
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        seen.add("0000");
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i +) {
                String cur = q.poll();
                if (deadEnds.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step=
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!seen.contains(up)) {
                        q.add(up);
                        seen.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!seen.contains(down)) {
                        q.add(down);
                        seen.add(down);
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
        } 1;
        return new String(ch);
    }
}