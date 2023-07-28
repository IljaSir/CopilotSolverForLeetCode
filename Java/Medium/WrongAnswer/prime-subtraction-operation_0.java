class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        int n = nums.length;
        int[] sub = new int[n];
        for (int i = 0; i < n; i++) {
            int p = 0;
            while (p < primes.length && primes[p] < nums[i]) {
                p++;
            }
            p--;
            sub[i] = p;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - primes[sub[j]] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1] == n - 1;
    }
}