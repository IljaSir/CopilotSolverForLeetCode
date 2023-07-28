impl Solution {
    pub fn max_product(s: String) -> i32 {
        
        let n = s.len();
        let s = s.chars().collect::<Vec<char>>();
        let mut dp = vec![vec![0; n]; n];
        for i in 0..n {
            dp[i][i] = 1;
        }
        for i in 0..n {
            for j in 0..i {
                if s[i] == s[j] {
                    if i == j + 1 {
                        dp[j][i] = 2;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    }
                } else {
                    dp[j][i] = dp[j + 1][i].max(dp[j][i - 1]);
                }
            }
        }
        let mut ans = 0;
        for i in 0..n {
            for j in 0..i {
                if dp[0][j] * dp[j + 1][i] > ans {
                    ans = dp[0][j] * dp[j + 1][i];
                }
                if dp[0][i] * dp[i + 1][n - 1] > ans {
                    ans = dp[0][i] * dp[i + 1][n - 1];
                }
            }
        }
        ans as i32
    }
}