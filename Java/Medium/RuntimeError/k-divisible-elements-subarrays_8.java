class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int[] mod = new int[p];
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
            int index = (sum - k + p) % p;
            res += mod[index];
            mod[sum]++;
            if (i >= k - 1) {
                mod[(sum - nums[i - k + 1] + p) % p]--;
            }
        }
        return res;
    }
}