class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        if (k == 0) return 2;
        int n = prizePositions.length;
        int[] dp = new int[n];
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            while (left < i && prizePositions[i] - prizePositions[left] > k) left++;
            while (right < n && prizePositions[right] - prizePositions[i] <= k) right++;
            int l = left > 0 ? dp[left - 1] : 0;
            dp[i] = Math.max(dp[i], right - left + l);
            if (i > 0) dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}