impl Solution {
    pub fn count_squares(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut res = 0;
        let m = matrix.len();
        let n = matrix[0].len();
        let mut dp = vec![vec![0; n+1]; m+1];
        for i in 1..=m {
            for j in 1..=n {
                if matrix[i-1][j-1] == 1 {
                    dp[i][j] = 1 + dp[i-1][j].min(dp[i][j-1]).min(dp[i-1][j-1]);
                    res += dp[i][j];
                }
            }
        }
        res
    }
}