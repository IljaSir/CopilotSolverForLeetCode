impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![vec![std::i32::MAX; nums.len() + 1]; k as usize + 1];
        let mut sums = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            sums[i + 1] = sums[i] + nums[i];
        }
        dp[0][0] = 0;
        for i in 1..=k as usize {
            for j in 1..=nums.len() {
                for p in 0..j {
                    dp[i][j] = std::cmp::min(dp[i][j], std::cmp::max(dp[i - 1][p], sums[j] - sums[p]));
                }
            }
        }
        dp[k as usize][nums.len()]
    }
}