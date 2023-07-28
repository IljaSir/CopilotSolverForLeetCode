impl Solution {
    pub fn find_paths(m: i32, n: i32, max_move: i32, start_row: i32, start_column: i32) -> i32 {
        

        let m = m as usize;
        let n = n as usize;
        let max_move = max_move as usize;
        let start_row = start_row as usize;
        let start_column = start_column as usize;
        let mut dp = vec![vec![vec![0; n]; m]; max_move + 1];
        let mut sum = 0;
        let mut mod_ = 1_000_000_007;
        dp[0][start_row][start_column] = 1;
        for i in 0..max_move {
            for j in 0..m {
                for k in 0..n {
                    let count = dp[i][j][k];
                    if count > 0 {
                        if j > 0 {
                            dp[i + 1][j - 1][k] = (dp[i + 1][j - 1][k] + count) % mod_;
                        } else {
                            sum = (sum + count) % mod_;
                        }
                        if j < m - 1 {
                            dp[i + 1][j + 1][k] = (dp[i + 1][j + 1][k] + count) % mod_;
                        } else {
                            sum = (sum + count) % mod_;
                        }
                        if k > 0 {
                            dp[i + 1][j][k - 1] = (dp[i + 1][j][k - 1] + count) % mod_;
                        } else {
                            sum = (sum + count) % mod_;
                        }
                        if k < n - 1 {
                            dp[i + 1][j][k + 1] = (dp[i + 1][j][k + 1] + count) % mod_;
                        } else {
                            sum = (sum + count) % mod_;
                        }
                    }
                }
            }
        }
        sum
    }
}