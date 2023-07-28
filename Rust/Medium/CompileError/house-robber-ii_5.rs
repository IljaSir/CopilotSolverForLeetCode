impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        if n == 1 {
            return nums[0];
        }
        let mut dp = vec![0; n];
        dp[0] = nums[0];
        dp[1] = dp[0].max(nums[1]);
        for i in 2..n - 1 {
            dp[i] = dp[i - 1].max(dp[i - 2] + nums[i]);
        }
        let mut ans = dp[n - 2];
        dp[1] = nums[1];
        for i in 2..n {
            dp[i] = dp[i - 1].max(dp[i - 2] + nums[i]);
        }
        ans = ans.max(dp[n - 1]);
        ans
    }
}