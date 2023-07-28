impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let n = s.len();
        if n < 2 {
            return s;
        }
        let s = s.as_bytes();
        let mut dp = vec![vec![false; n]; n];
        let mut max_len = 1;
        let mut start = 0;
        for i in 0..n {
            dp[i][i] = true;
        }
        for j in 1..n {
            for i in 0..j {
                if s[i] != s[j] {
                    dp[i][j] = false;
                } else {
                    if j - i < 3 {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                
                if dp[i][j] && j - i + 1 > max_len {
                    max_len = j - i + 1;
                    start = i;
                }
            }
        }
        String::from_utf8(s[start..start + max_len].to_vec()).unwrap()
    }
}