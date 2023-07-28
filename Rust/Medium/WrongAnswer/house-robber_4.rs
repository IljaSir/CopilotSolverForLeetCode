impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        let mut dp = vec![0; nums.len() + 2];
        for i in 0..nums.len() {
            dp[i + 2] = std::cmp::max(dp[i], dp[i + 1]) + nums[i];
        }
        std::cmp::max(dp[nums.len()], dp[nums.len() + 1])
    }
}