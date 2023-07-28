class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n = rolls.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] cnt = new int[k+1];
        cnt[rolls[0]]++;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int j = i - k;
            if (j >= 0) {
                cnt[rolls[j]]--;
            }
            cnt[rolls[i]]++;
            if (cnt[rolls[i]] > 1) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}