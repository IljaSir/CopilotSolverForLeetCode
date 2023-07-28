impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        let mut dp = vec![0; nums.len() + 2];
        for i in 0..nums.len() {
            dp[i + 2] = std::cmp::max(dp[i] + nums[i], dp[i + 1]);
        }
        dp[nums.len() + 1]
    }
}