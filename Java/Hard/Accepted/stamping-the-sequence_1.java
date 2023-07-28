class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        List<Integer> list = new ArrayList<>();
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] visited = new boolean[t.length];
        int count = 0;
        while (count < t.length) {
            boolean done = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (!visited[i] && canReplace(s, t, i)) {
                    list.add(i);
                    count = replace(s, t, i, count);
                    visited[i] = true;
                    done = true;
                    if (count == t.length) {
                        break;
                    }
                }
            }
            if (!done) {
                return new int[0];
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - i - 1);
        }
        return res;
    }
    
    private boolean canReplace(char[] s, char[] t, int start) {
        for (int i = 0; i < s.length; i++) {
            if (t[start + i] != '?' && t[start + i] != s[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int replace(char[] s, char[] t, int start, int count) {
        for (int i = 0; i < s.length; i++) {
            if (t[start + i] != '?') {
                t[start + i] = '?';
                count++;
            }
        }
        return count;
    }
}