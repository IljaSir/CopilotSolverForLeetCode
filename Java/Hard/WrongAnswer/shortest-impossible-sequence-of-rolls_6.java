class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n = rolls.length;
        int[] cnt = new int[k + 1];
        int[] sum = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] q = new int[n + 1];
        int head = 0, tail = 0;
        q[tail++] = 0;
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + rolls[i];
            cnt[rolls[i]]++;
            while (cnt[rolls[i]] > 1) {
                cnt[rolls[q[head++]]]--;
            }
            while (head < tail && sum[i + 1] - sum[q[head]] > k) {
                cnt[rolls[q[head++]]]--;
            }
            dp[i + 1] = dp[q[head]] + 1;
            while (head < tail && dp[i + 1] <= dp[q[tail - 1]]) {
                tail--;
            }
            q[tail++] = i + 1;
        }
        return dp[n];
    }
}