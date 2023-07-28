class Solution {
    public int splitNum(int num) {
        
        int[] freq = new int[10];
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        int[] dp = new int[1 << 10];
        for (int mask = 1; mask < 1 << 10; mask++) {
            dp[mask] = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                if ((mask & (1 << i)) > 0) {
                    sum += i * freq[i];
                }
            }
            for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                dp[mask] = Math.min(dp[mask], dp[submask] + sum);
            }
        }
        return dp[(1 << 10) - 1];
    }
}