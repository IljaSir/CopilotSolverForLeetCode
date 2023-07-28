impl Solution {
    pub fn count_palindromes(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![0; n]; n];
        let mut ans = 0;
        for i in 0..n {
            dp[i][i] = 1;
            ans += 1;
        }
        for i in (0..n).rev() {
            for j in i+1..n {
                if s[i] == s[j] {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1;
                    if i+1 <= j-1 {
                        dp[i][j] -= dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                }
                if i+4 <= j {
                    ans = (ans + dp[i+1][j-1]) % 1000000007;
                }
            }
        }
        ans
    }
}