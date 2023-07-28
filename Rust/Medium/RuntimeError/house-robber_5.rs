impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        let mut dp = vec![0; nums.len() + 1];
        for i in 1..nums.len() + 1 {
            dp[i] = std::cmp::max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        dp[nums.len()]
    }
}