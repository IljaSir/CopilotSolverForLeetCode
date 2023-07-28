impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        if n == 1 {
            return nums[0];
        }
        let mut dp = vec![0; n];
        dp[0] = nums[0];
        dp[1] = nums[0].max(nums[1]);
        for i in 2..n {
            dp[i] = dp[i - 1].max(dp[i - 2] + nums[i]);
        }
        let mut dp2 = vec![0; n];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for i in 2..n {
            dp2[i] = dp2[i - 1].max(dp2[i - 2] + nums[i]);
        }
        dp[n - 1].max(dp2[n - 1])
    }
}