impl Solution {
    pub fn min_capability(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let k = k as usize;
        let mut dp = vec![vec![0; k+1]; n+1];
        for i in 0..n {
            for j in 1..=k {
                dp[i+1][j] = dp[i][j];
                if j <= i {
                    dp[i+1][j] = dp[i+1][j].max(dp[i][j-1] + nums[i]);
                }
            }
        }
        dp[n][k]
    }
}