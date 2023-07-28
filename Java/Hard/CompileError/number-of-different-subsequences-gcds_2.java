class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int[] count = new int[max + 1];
        for (int n : nums) {
            count[n]++;
        }
        int[] dp = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                dp[i] += count[j];
            }
        }
        int res = 0;
        for (int i = 1; i <= max; i++) {
            if (dp[i] > 0) {
                int g = 0;
                for (int j = i; j <= max; j += i) {
                    g = gcd(g, j);
                }
                if (g == i) {
                    res++;
                }
            }
        }
        return res;
    }
}