impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        

        let mut dp = vec![0; nums.len() + 2];
        for (i, &money) in nums.iter().enumerate() {
            dp[i + 2] = std::cmp::max(dp[i + 1], dp[i] + money);
        }
        *dp.last().unwrap()
    }
}