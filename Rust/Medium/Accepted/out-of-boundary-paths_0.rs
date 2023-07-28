impl Solution {
    pub fn find_paths(m: i32, n: i32, max_move: i32, start_row: i32, start_column: i32) -> i32 {
        

        let m = m as usize;
        let n = n as usize;
        let max_move = max_move as usize;
        let start_row = start_row as usize;
        let start_column = start_column as usize;
        let mut dp = vec![vec![vec![0; n]; m]; max_move + 1];
        let mut ans = 0;
        dp[0][start_row][start_column] = 1;
        let modu = 1_000_000_007;
        for i in 0..max_move {
            for j in 0..m {
                for k in 0..n {
                    let count = dp[i][j][k];
                    if count > 0 {
                        if j > 0 {
                            dp[i + 1][j - 1][k] = (dp[i + 1][j - 1][k] + count) % modu;
                        } else {
                            ans = (ans + count) % modu;
                        }
                        if j + 1 < m {
                            dp[i + 1][j + 1][k] = (dp[i + 1][j + 1][k] + count) % modu;
                        } else {
                            ans = (ans + count) % modu;
                        }
                        if k > 0 {
                            dp[i + 1][j][k - 1] = (dp[i + 1][j][k - 1] + count) % modu;
                        } else {
                            ans = (ans + count) % modu;
                        }
                        if k + 1 < n {
                            dp[i + 1][j][k + 1] = (dp[i + 1][j][k + 1] + count) % modu;
                        } else {
                            ans = (ans + count) % modu;
                        }
                    }
                }
            }
        }
        ans
    }
}