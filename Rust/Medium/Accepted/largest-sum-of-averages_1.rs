impl Solution {
    pub fn largest_sum_of_averages(nums: Vec<i32>, k: i32) -> f64 {
        
        let n = nums.len();
        let mut dp = vec![vec![0.0; n]; k as usize];
        let mut sum = vec![0.0; n];
        sum[0] = nums[0] as f64;
        for i in 1..n {
            sum[i] = sum[i - 1] + nums[i] as f64;
        }
        for i in 0..n {
            dp[0][i] = sum[i] / (i + 1) as f64;
        }
        for i in 1..k as usize {
            for j in i..n {
                for m in i - 1..j {
                    dp[i][j] = dp[i][j].max(dp[i - 1][m] + (sum[j] - sum[m]) / (j - m) as f64);
                }
            }
        }
        dp[k as usize - 1][n - 1]
    }
}