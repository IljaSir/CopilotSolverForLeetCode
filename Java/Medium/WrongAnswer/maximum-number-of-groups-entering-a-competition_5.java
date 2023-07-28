class Solution {
    public int maximumGroups(int[] grades) {
        
        int[] count = new int[100001];
        for (int grade : grades) {
            count[grade]++;
        }
        int[] dp = new int[100001];
        int res = 0;
        for (int i = 1; i <= 100000; i++) {
            if (count[i] == 0) {
                continue;
            }
            dp[i] = count[i];
            res = Math.max(res, dp[i]);
            for (int j = i + i; j <= 100000; j += i) {
                dp[j] = Math.max(dp[j], dp[i]);
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}