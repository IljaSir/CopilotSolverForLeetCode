class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] primes = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (primes[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    primes[j] = i;
                }
            }
        }
        int[] pow = new int[max + 1];
        int[] dp = new int[max + 1];
        dp[1] = 1;
        for (int i = 2; i <= max; i++) {
            int p = primes[i];
            int x = i / p;
            if (x % p == 0) {
                dp[i] = dp[x];
            } else {
                pow[i] = pow[x] + 1;
                dp[i] = dp[x] * (pow[i] % 2 == 0 ? 1 : -1);
            }
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int s = 0;
            for (int j = i; j <= max; j += i) {
                s += cnt[j] * dp[j / i];
            }
            ans += s % 2 == 1 ? 1 : -1;
        }
        return ans;
    }
}