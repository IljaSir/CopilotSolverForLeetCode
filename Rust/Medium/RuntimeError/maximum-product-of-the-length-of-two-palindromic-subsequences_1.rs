impl Solution {
    pub fn max_product(s: String) -> i32 {
        
        let n = s.len();
        let s = s.into_bytes();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 1;
        }
        for i in (0..n).rev() {
            for j in i + 1..n {
                if s[i] == s[j] {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = dp[i + 1][j].max(dp[i][j - 1]);
                }
            }
        }
        let mut ans = 0;
        for i in 0..n {
            for j in i + 1..n {
                if dp[0][i] * dp[i + 1][j] > ans {
                    ans = dp[0][i] * dp[i + 1][j];
                }
                if dp[0][i] * dp[j + 1][n - 1] > ans {
                    ans = dp[0][i] * dp[j + 1][n - 1];
                }
                if dp[i + 1][j] * dp[j + 1][n - 1] > ans {
                    ans = dp[i + 1][j] * dp[j + 1][n - 1];
                }
            }
        }
        ans as i32
    }
}