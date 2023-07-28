impl Solution {
    pub fn max_size_slices(slices: Vec<i32>) -> i32 {
        
        let n = slices.len();
        let m = n / 3;
        let mut dp = vec![vec![vec![0; m + 1]; n]; 2];
        for i in 0..n {
            for j in 0..m + 1 {
                if j == 0 {
                    dp[0][i][j] = 0;
                } else {
                    dp[0][i][j] = i32::max(dp[0][(i + n - 1) % n][j], dp[0][(i + n - 1) % n][j - 1] + slices[i]);
                }
            }
        }
        for i in 0..n {
            for j in 0..m + 1 {
                if j == 0 {
                    dp[1][i][j] = 0;
                } else {
                    dp[1][i][j] = i32::max(dp[1][(i + n - 1) % n][j], dp[1][(i + n - 1) % n][j - 1] + slices[i]);
                }
            }
        }
        let mut ans = dp[0][n - 2][m];
        for i in 0..n {
            ans = i32::max(ans, dp[0][(i + n - 1) % n][m - 1] + dp[1][(i + 1) % n][m]);
        }
        ans
    }
}