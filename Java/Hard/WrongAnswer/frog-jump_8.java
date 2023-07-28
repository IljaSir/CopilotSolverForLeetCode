class Solution {
    public boolean canCross(int[] stones) {
        
        int n = stones.length;
        if (stones[1] != 1) return false;
        if (n == 2) return true;
        if (stones[2] != 2) return false;
        if (n == 3) return true;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            int last = stones[i] - stones[i - 1];
            int last2 = stones[i - 1] - stones[i - 2];
            if (last > last2 + 1) return false;
            if (last < last2 - 1) return false;
            dp[i] = last;
        }
        for (int i = 3; i < n; i++) {
            int last = stones[i] - stones[i - 1];
            int last2 = stones[i - 1] - stones[i - 2];
            if (last > last2 + 1) return false;
            if (last < last2 - 1) return false;
            dp[i] = last;
        }
        return true;
    }
}