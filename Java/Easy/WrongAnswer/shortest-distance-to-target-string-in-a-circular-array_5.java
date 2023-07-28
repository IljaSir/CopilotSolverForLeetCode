class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
        
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                prev[i] = i;
                next[i] = i;
            }
        }
        
        for (int i = (startIndex - 1 + n) % n; i != startIndex; i = (i - 1 + n) % n) {
            if (prev[(i + 1) % n] != -1) {
                prev[i] = prev[(i + 1) % n];
            }
        }
        
        for (int i = (startIndex + 1) % n; i != startIndex; i = (i + 1) % n) {
            if (next[(i - 1 + n) % n] != -1) {
                next[i] = next[(i - 1 + n) % n];
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (prev[i] != -1 && next[i] != -1) {
                ans = Math.min(ans, Math.min(Math.abs(i - prev[i]), Math.abs(i - next[i])));
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}