class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        int n = nums.length;
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i < 1001; i++) {
            if (prime[i]) {
                for (int j = i + i; j < 1001; j += i) {
                    prime[j] = false;
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                if (prime[dp[j]] && dp[j] < dp[i]) {
                    dp[i] = dp[j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] != nums[i]) {
                return true;
            }
        }
        return false;
    }
}