impl Solution {
    pub fn min_capability(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let k = k as usize;
        let mut dp = vec![vec![0; n + 1]; k + 1];
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + nums[i];
        }
        for i in 1..=k {
            for j in i..=n {
                dp[i][j] = i32::max_value();
                for p in i - 1..j {
                    dp[i][j] = dp[i][j].min(dp[i - 1][p].max(sum[j] - sum[p]));
                }
            }
        }
        dp[k][n]
    }
}