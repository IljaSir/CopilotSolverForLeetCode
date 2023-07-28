class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (blocks.charAt(i) == 'B') {
                count[i + 1] = count[i] + 1;
            } else {
                count[i + 1] = count[i];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            ans = Math.min(ans, count[i] + count[n] - count[i + k] - (k - (count[i + k] - count[i])));
        }
        return ans;
    }
}