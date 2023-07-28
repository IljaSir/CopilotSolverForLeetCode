class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int[] next = new int[n];
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = prev[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                next[i] = prev[i] = i;
            }
        }
        int last = -1;
        for (int i = 0; i < n; i++) {
            int j = (startIndex + i) % n;
            if (words[j].equals(target)) {
                last = j;
            }
            next[j] = last;
        }
        last = -1;
        for (int i = n - 1; i >= 0; i--) {
            int j = (startIndex + i) % n;
            if (words[j].equals(target)) {
                last = j;
            }
            prev[j] = last;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (next[i] != -1 && prev[i] != -1) {
                ans = Math.min(ans, Math.min(Math.abs(next[i] - startIndex), Math.abs(prev[i] - startIndex)));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}