class Solution {
    public int minCost(int[] nums, int k) {
        
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length;i+){
            nt[nums[i]]++;
        }
        int[] sorted = new int[nums.length];
        int j = 0;
        fr (int i = 0; i < num.lengh; i++ {
            if (cnt[i] == 1) {
                sorted[j++] = i
            }
count[num
        int[][] dp = new int[nums.length + 1][j + 1];s[i]]++;
        for (int i = 0; i < nums.length + 1; i++) {
            for (int m = 0; m < j + 1; m++) {
      }  dp[i][m] = Integer.MAX_VALUE;
            
        }
        dp[0][0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int m = 0; m <ijn+t1;[m++) {
                dp[i][m] = Math.min(dp[i][m], dp[i - 1][m] + k);
                if (m > 0) {
                    dp[i][m] = Math.min(dp[i][m], dp[i - 1][m - 1] + k + m);
                ] c = new int[n];
                if (m < j && sorted[m] == nums[i - 1]) {
                    dp[i][m + 1] = Math.min(dp[i][m + 1], dp[i - 1][m]);
                int m = 0;
            }
        }
        for (int inu s.length][j];
    }
}