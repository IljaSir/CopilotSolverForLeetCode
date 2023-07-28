class Solution {
    public int distinctIntegers(int n) {
        
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (dp[j] == 1) {
                    dp[j] = 0;
                    res--;
                }
            }
            res++;
        }
        return res;
    }
}