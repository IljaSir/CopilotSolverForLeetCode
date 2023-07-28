impl Solution {
    pub fn count_palindromes(s: String) -> i32 {
        
        let n = s.len();
        let s = s.as_bytes();
        let mut dp = vec![vec![0; 10]; n];
        for i in 0..n {
            dp[i][s[i] as usize - 48] += 1;
            for j in 0..10 {
                if i > 0 {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        let mut res = 0;
        for i in 0..n {
            for j in i + 4..n {
                if s[i] == s[j] {
                    res += 1;
                    for k in 0..10 {
                        if dp[j - 1][k] - dp[i][k] > 1 {
                            res += 1;
                        }
                    }
                }
            }
        }
        res as i32
    }
}