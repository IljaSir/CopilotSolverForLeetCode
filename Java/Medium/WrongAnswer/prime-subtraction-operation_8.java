class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        int n = nums.length;
        int[] primes = new int[1000];
        int count = 0;
        for (int i = 2; i < 1000; i++) {
            if (isPrime(i)) {
                primes[count++] = i;
            }
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < count; j++) {
                if (primes[j] < nums[i]) {
                    for (int k = 0; k < i; k++) {
                        if (nums[k] - primes[j] == nums[i]) {
                            dp[i] = 1;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}