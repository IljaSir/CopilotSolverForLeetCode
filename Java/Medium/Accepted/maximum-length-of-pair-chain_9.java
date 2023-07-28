class Solution {
    public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int n = pairs.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] pair = pairs[i];
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pair[0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}