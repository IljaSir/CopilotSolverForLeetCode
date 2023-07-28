impl Solution {
    pub fn count_palindromes(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![vec![0; 10]; n];
        for i in 0..n {
            dp[i][s[i] - b'0'] = 1;
        }
        for i in 1..n {
            for j in 0..10 {
                dp[i][j] += dp[i - 1][j];
            }
        }
        let mut res = 0;
        for i in 0..n {
            for j in i + 4..n {
                if s[i] == s[j] {
                    let mut diff = 0;
                    for k in 0..10 {
                        if dp[j - 1][k] - dp[i][k] > 0 {
                            diff += 1;
                        }
                    }
                    if diff <= 1 {
                        res += 1;
                    }
                }
            }
        }
        res as i32
    }
}