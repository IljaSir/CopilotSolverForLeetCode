class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        int[] primes = new int[1000];
        int primeCount = 0;
        for (int i = 2; i < 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primes[primeCount] = i;
                primeCount++;
            }
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    continue;
                }
                for (int k = 0; k < primeCount; k++) {
                    if (nums[j] - primes[k] > 0 && nums[j] - primes[k] < nums[i]) {
                        max = Math.max(dp[j], max);
                    }
                }
            }
            dp[i] = max + 1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max == nums.length;
    }
}