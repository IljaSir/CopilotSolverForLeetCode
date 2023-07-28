impl Solution {
    pub fn count_palindromes(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![0; n]; n];
        let mut ans = 0;
        for i in (0..n).rev() {
            dp[i][i] = 1;
            for j in i + 1..n {
                if s[i] == s[j] {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                if j - i == 4 {
                    ans += 1;
                }
            }
        }
        ans
    }
}