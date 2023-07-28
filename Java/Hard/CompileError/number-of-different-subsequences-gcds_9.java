class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int n = 200000;
        boolean[] seen = new boolean[n + 1];
        for (int num : nums) {
            seen[num] = true;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (seen[j]) {
                    dp[i] = gcd(dp[i], j);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] == i) {
                ans++;
            }
        }
        return ans;
    }
}