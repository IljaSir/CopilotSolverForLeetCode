impl Solution {
    pub fn maximum_score(nums: Vec<i32>, multipliers: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let m = multipliers.len();
        let mut dp = vec![vec![0; m + 1]; 2];
        for i in 0..m {
            let (x, y) = (i % 2, (i + 1) % 2);
            dp[x][i + 1] = dp[x][i] + multipliers[i] * nums[i];
            dp[y][i + 1] = dp[y][i] + multipliers[i] * nums[n - i - 1];
            for j in (0..i).rev() {
                dp[x][j + 1] = (dp[x][j] + multipliers[i] * nums[i - j]).max(dp[x][j + 1] + multipliers[i] * nums[n - i + j]);
                dp[y][j + 1] = (dp[y][j] + multipliers[i] * nums[n - i + j]).max(dp[y][j + 1] + multipliers[i] * nums[i - j]);
            }
        }
        dp[0].iter().chain(dp[1].iter()).max().unwrap().clone()
    }
}