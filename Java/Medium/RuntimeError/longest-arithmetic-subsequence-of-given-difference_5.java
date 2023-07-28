class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int[] dp = new int[20001];
        int ans = 0;
        for (int a: arr) {
            dp[a + 10000] = dp[a - difference + 10000] + 1;
            ans = Math.max(ans, dp[a + 10000]);
        }
        return ans;
    }
}