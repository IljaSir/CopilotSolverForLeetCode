impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        if nums.len() == 1 {
            return nums[0];
        }
        let mut dp = vec![0; nums.len()];
        dp[0] = nums[0];
        dp[1] = nums[1].max(nums[0]);
        for i in 2..nums.len() {
            dp[i] = dp[i - 1].max(dp[i - 2] + nums[i]);
        }
        let mut dp1 = vec![0; nums.len()];
        dp1[1] = nums[1];
        dp1[2] = nums[2].max(nums[1]);
        for i in 3..nums.len() {
            dp1[i] = dp1[i - 1].max(dp1[i - 2] + nums[i]);
        }
        dp[nums.len() - 2].max(dp1[nums.len() - 1])
    }
}