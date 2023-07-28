class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> deads = new HashSet<>();
        for (String d: deadends) deads.add(d);
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        q.offer(null);
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        int depth = 0;
        while (!q.isEmpty()) {
            String node = q.poll();
            if (node == null) {
                depth++;
                if (q.peek() != null) q.offer(null);
            } else if (deads.contains(node)) {
                continue;
            } else if (target.equals(node)) {
                return depth;
            } else {
                for (int i = 0; i < 4; ++i) {
                    String up = plusOne(node, i);
                    if (!seen.contains(up)) {
                        q.offer(up);
                        seen.add(up);
                    }
                    String down = minusOne(node, i);
                    if (!seen.contains(down)) {
                        q.offer(down);
                        seen.add(down);
                    }
                }
            }
        }
        return -1;
    }
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') ch[j] = '0';
        else ch[j] += 1;
        return new String(ch);
    }
}