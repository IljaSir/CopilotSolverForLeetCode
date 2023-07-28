impl Solution {
    pub fn largest_sum_of_averages(nums: Vec<i32>, k: i32) -> f64 {
        
        let mut dp = vec![vec![0.0; nums.len()]; k as usize];
        let mut sum = 0;
        for (i, &num) in nums.iter().enumerate() {
            sum += num;
            dp[0][i] = sum as f64 / (i + 1) as f64;
        }
        for i in 1..k as usize {
            for j in i..nums.len() {
                sum = 0;
                for p in (i - 1..j).rev() {
                    sum += nums[p];
                    dp[i][j] = dp[i][j].max(dp[i - 1][p - 1] + sum as f64 / (j - p + 1) as f64);
                }
            }
        }
        dp[k as usize - 1][nums.len() - 1]
    }
}