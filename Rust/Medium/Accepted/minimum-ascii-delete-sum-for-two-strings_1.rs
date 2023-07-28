impl Solution {
    pub fn minimum_delete_sum(s1: String, s2: String) -> i32 {
        

        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut dp = vec![vec![0; s2.len() + 1]; s1.len() + 1];
        for i in 0..s1.len() {
            dp[i + 1][0] = dp[i][0] + s1[i] as i32;
        }
        for i in 0..s2.len() {
            dp[0][i + 1] = dp[0][i] + s2[i] as i32;
        }
        for i in 0..s1.len() {
            for j in 0..s2.len() {
                if s1[i] == s2[j] {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = std::cmp::min(dp[i][j + 1] + s1[i] as i32, dp[i + 1][j] + s2[j] as i32);
                }
            }
        }
        dp[s1.len()][s2.len()]
    }
}