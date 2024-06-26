impl Solution {
    pub fn count_squares(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 0;
        let m = matrix.len();
        let n = matrix[0].len();
        let mut dp = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                if matrix[i][j] == 1 {
                    if i == 0 || j == 0 {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = (dp[i - 1][j - 1].min(dp[i - 1][j].min(dp[i][j - 1]))) + 1;
                    }
                }
                ans += dp[i][j];
            }
        }
        ans
    }
}