class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        int n = target.length();
        char[] t = target.toCharArray();
        boolean[] visited = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        while (count < n) {
            boolean done = false;
            for (int i = 0; i <= n - stamp.length(); i++) {
                if (!visited[i] && canConvert(stamp, t, i)) {
                    ans.add(i);
                    count += convert(stamp, t, i);
                    visited[i] = true;
                    done = true;
                }
            }
            if (!done) {
                return new int[0];
            }
        }
        Collections.reverse(ans);
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }
    
    public boolean canConvert(String stamp, char[] t, int start) {
        for (int i = 0; i < stamp.length(); i++) {
            if (t[start + i] != '?' && t[start + i] != stamp.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public int convert(String stamp, char[] t, int start) {
        int count = 0;
        for (int i = 0; i < stamp.length(); i++) {
            if (t[start + i] != '?') {
                t[start + i] = '?';
                count++;
            }
        }
        return count;
    }
}