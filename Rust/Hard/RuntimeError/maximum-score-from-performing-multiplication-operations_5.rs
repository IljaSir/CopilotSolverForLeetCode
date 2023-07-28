impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let m = multipliers.len();
        let mut dp = vec![vec![0; m + 1]; 2];
        for i in 0..m {
            dp[0][i] = dp[0][i + 1] + multipliers[i] * nums[i];
        }
        for i in 1..m {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + multipliers[i] * nums[n - i];
            for j in 1..=i {
                dp[i % 2][j] = std::cmp::max(dp[(i - 1) % 2][j] + multipliers[i] * nums[n - i + j], dp[i % 2][j - 1] + multipliers[i] * nums[j - 1]);
            }
        }
        let mut ans = dp[0][m - 1];
        for i in 0..m {
            ans = std::cmp::max(ans, dp[(m - 1) % 2][i]);
        }
        ans
    }
}