impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        

        let len = s.len();
        let mut dp = vec![vec![false; len]; len];
        let mut ans = 0;
        for i in 0..len {
            dp[i][i] = true;
            ans += 1;
        }
        for i in (0..len).rev() {
            for j in i+1..len {
                if s.as_bytes()[i] == s.as_bytes()[j] {
                    if i+1 == j {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if dp[i][j] {
                    ans += 1;
                }
            }
        }
        ans
    }
}