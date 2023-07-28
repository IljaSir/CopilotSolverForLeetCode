impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        if nums.len() == 1 {
            return nums[0];
        }
        let mut dp = vec![0; nums.len()];
        dp[0] = nums[0];
        dp[1] = nums[0].max(nums[1]);
        for i in 2..nums.len() - 1 {
            dp[i] = dp[i - 1].max(dp[i - 2] + nums[i]);
        }
        let mut dp2 = vec![0; nums.len()];
        dp2[1] = nums[1];
        dp2[2] = nums[1].max(nums[2]);
        for i in 3..nums.len() {
            dp2[i] = dp2[i - 1].max(dp2[i - 2] + nums[i]);
        }
        dp[nums.len() - 2].max(dp2[nums.len() - 1])
    }
}