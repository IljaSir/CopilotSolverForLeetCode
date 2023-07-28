impl Solution {
    pub fn max_side_length(mat: Vec<Vec<i32>>, threshold: i32) -> i32 {
        
        let m = mat.len();
        let n = mat[0].len();
        let mut dp = vec![vec![0; n + 1]; m + 1];
        let mut ans = 0;
        for i in 1..=m {
            for j in 1..=n {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
                if i > ans && j > ans && dp[i][j] - dp[i - ans - 1][j] - dp[i][j - ans - 1] + dp[i - ans - 1][j - ans - 1] <= threshold {
                    ans += 1;
                }
            }
        }
        ans as i32
    }
}