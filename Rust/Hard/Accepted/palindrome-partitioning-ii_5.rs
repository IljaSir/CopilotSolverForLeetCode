impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let n = s.len();
        let s = s.as_bytes();
        let mut dp = vec![0; n];
        let mut is_palindrome = vec![vec![false; n]; n];
        for i in 0..n {
            let mut min_cut = i as i32;
            for j in 0..=i {
                if s[i] == s[j] && (i - j <= 2 || is_palindrome[j + 1][i - 1]) {
                    is_palindrome[j][i] = true;
                    min_cut = if j > 0 { min_cut.min(dp[j - 1] + 1) } else { 0 };
                }
            }
            dp[i] = min_cut;
        }
        dp[n - 1]
    }
}