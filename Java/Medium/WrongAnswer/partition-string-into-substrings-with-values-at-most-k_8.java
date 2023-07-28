class Solution {
    public int minimumPartition(String s, int k) {
        
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        return minPartition(nums, k);
    }
    
    private int minPartition(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n + 1);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int max = 0;
            for (int j = i; j >= 0; j--) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                if (max * (i - j + 1) - sum > k) break;
                dp[i] = Math.min(dp[i], (j > 0 ? dp[j - 1] : 0) + 1);
            }
        }
        return dp[n - 1] == n + 1 ? -1 : dp[n - 1];
    }
}