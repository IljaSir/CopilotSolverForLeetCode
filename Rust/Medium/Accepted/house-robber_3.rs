impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        let mut dp = vec![0; nums.len() + 2];
        for i in (0..nums.len()).rev() {
            dp[i] = std::cmp::max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        dp[0]
    }
}