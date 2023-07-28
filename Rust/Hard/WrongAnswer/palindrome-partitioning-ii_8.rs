impl Solution {
    pub fn min_cut(s: String) -> i32 {
        
        let s: Vec<_> = s.chars().collect();
        let n = s.len();
        let mut dp = vec![vec![false; n]; n];
        let mut cut = vec![0; n];
        for i in (0..n).rev() {
            let mut min = i32::MAX;
            for j in i..n {
                if s[i] == s[j] && (j - i <= 2 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    min = min.min(if j < n - 1 { cut[j + 1] } else { -1 }) + 1;
                }
            }
            cut[i] = min;
        }
        cut[0]
    }
}