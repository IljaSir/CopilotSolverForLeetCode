class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n = rolls.length;
        int[] dp = new int[n];
        int[] last = new int[k+1];
        Arrays.fill(last, -1);
        dp[0] = 1;
        last[rolls[0]] = 0;
        for (int i = 1; i < n; i++) {
            int x = rolls[i];
            if (i >= k) {
                int y = rolls[i-k];
                if (last[y] == i-k) {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                dp[i] = dp[i-1] + 1;
            }
            last[x] = i;
        }
        return dp[n-1];
    }
}