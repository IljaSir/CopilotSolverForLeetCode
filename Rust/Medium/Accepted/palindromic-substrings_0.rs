impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        

        let n = s.len();
        let s = s.as_bytes();
        let mut dp = vec![vec![false; n]; n];
        let mut ans = 0;
        for i in (0..n).rev() {
            for j in i..n {
                dp[i][j] = (s[i] == s[j]) && (j - i < 2 || dp[i + 1][j - 1]);
                if dp[i][j] {
                    ans += 1;
                }
            }
        }
        ans
    }
}