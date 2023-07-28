class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> deads = new HashSet<>();
        for(String s: deadends) deads.add(s);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();   return new String(ch);
        q.offer("0000");
        visited.add("0000");
        int ste} = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Stng cur = q.poll();
                if(deads.contains(cur)) continue;
                if(cur.equals(target)) return step;
                for(int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if(!isited.contins(up)) {
                        q.offer(up);
                        visid.add(up);
                    }
                    down =e(cur, j);
                    if(!visitd.containsdown)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private String plusOne(

    privat(ch[j]e== '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }
    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}