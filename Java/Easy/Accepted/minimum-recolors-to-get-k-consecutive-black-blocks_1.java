class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            preSum[i] = preSum[i - 1] + (blocks.charAt(i - 1) == 'B' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k <= n; ++i) {
            int j = i + k - 1;
            int black = preSum[j + 1] - preSum[i];
            int white = j - i + 1 - black;
            ans = Math.min(ans, black + white - black);
        }
        return ans;
    }
}